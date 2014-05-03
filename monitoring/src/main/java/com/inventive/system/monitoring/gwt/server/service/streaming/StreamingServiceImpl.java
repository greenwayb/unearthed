package com.inventive.system.monitoring.gwt.server.service.streaming;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.inventive.system.monitoring.gwt.client.service.streaming.StreamMessage;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.*;
import java.util.concurrent.*;

/**
 * User: grant
 */
@Service
public class StreamingServiceImpl extends RemoteServiceServlet implements StreamingService {


    /** Queues for messages, keyed by session id. */
    private final ConcurrentMap<String, BlockingQueue<StreamMessage>> messageQueues = new ConcurrentHashMap<String, BlockingQueue<StreamMessage>>();

    private Map<String, DateAndInterval> heartBeats = new HashMap<String, DateAndInterval>();

    private ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();

    @PostConstruct
    public void init() {
        executorService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                Date now = new Date();
                for (Map.Entry<String, DateAndInterval> entry : heartBeats.entrySet()) {
                    if (entry.getValue().getExpiry().before(now)) {
                        stopStreamingSession(entry.getKey());
                    }
                }
            }
        }, 1, 1, TimeUnit.SECONDS);
    }

    @PreDestroy
    public void destroy() {
        executorService.shutdownNow();
    }

    @Override
    public String startStreamSession(int interval) {
        String sessionId = UUID.randomUUID().toString();
        messageQueues.put(sessionId, new LinkedBlockingQueue<StreamMessage>());

        Calendar c = Calendar.getInstance();
        c.add(Calendar.MILLISECOND, interval*10);

        heartBeats.put(sessionId, new DateAndInterval(c.getTime(), interval));
        return sessionId;
    }

    @Override
    public void stopStreamingSession(String sessionId) {
        if (messageQueues.remove(sessionId) != null) {
            heartBeats.remove(sessionId);
        }
    }

    /**
     * Retrieves the message queue for the session id
     * @param sessionId the session id
     * @return the message queue
     */
    private BlockingQueue<StreamMessage> getMessageQueue(String sessionId) {
        BlockingQueue<StreamMessage> messageQueue = messageQueues.get(sessionId);
        if (messageQueue == null) {
            messageQueue = new LinkedBlockingQueue<StreamMessage>();
            BlockingQueue<StreamMessage> existing = messageQueues.putIfAbsent(sessionId, messageQueue);
            if (existing != null) {
                messageQueue = existing;
            }
        }
        return messageQueue;
    }

    @Override
    public ArrayList<StreamMessage> getMessages(String sessionId) {
        List<StreamMessage> messages = null;
        if (sessionId == null) {
            return new ArrayList<StreamMessage>();
        }

        BlockingQueue<StreamMessage> messageQueue = getMessageQueue(sessionId);

        ArrayList<StreamMessage> messagesToSend = new ArrayList<StreamMessage>();
        if (null != messageQueue && !messageQueue.isEmpty()) {
            messageQueue.drainTo(messagesToSend);
        }


        //Update the heartbeat interval
        DateAndInterval expiry = heartBeats.get(sessionId);
        if (null != expiry) {
            Calendar c = Calendar.getInstance();
            c.add(Calendar.MILLISECOND, expiry.getInterval()*10);
            expiry.setExpiry(c.getTime());
        }


        return messagesToSend;
    }

    @Override
    public void sendToAll(StreamMessage message) {


        for (String sessionId : messageQueues.keySet()) {
            try {
                sendToSession(sessionId, message);
            } catch (IllegalStateException e) {
                e.printStackTrace();
            }
        }
    }


    @Override
    public void sendToSession(String sessionId, StreamMessage message) {
        synchronized (this) {
            BlockingQueue<StreamMessage> messageQueue = getMessageQueue(sessionId);
            if (messageQueue != null) {
                messageQueue.add(message);
            } else {
                throw new IllegalStateException("Unknown sessionId: " + sessionId);
            }
        }
    }

    private class DateAndInterval {
        private Date expiry;
        private int interval;

        public DateAndInterval(Date expiry, int interval) {
            this.expiry = expiry;
            this.interval = interval;
        }

        public Date getExpiry() {
            return expiry;
        }

        public int getInterval() {
            return interval;
        }

        public void setExpiry(Date expiry) {
            this.expiry = expiry;
        }
    }


}
