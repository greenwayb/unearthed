package com.inventive.system.monitoring.gwt.client.service.streaming;

import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.inventive.system.monitoring.gwt.client.service.action.AbstractAsyncCallback;
import com.inventive.system.monitoring.gwt.client.service.action.ActionServiceAsync;

import java.util.*;

/**
 * User: grant
 */
public class StreamingServiceImpl implements StreamingService {

    private ActionServiceAsync actionService;
    private Timer timer;
    private Map<Class, List<StreamMessageHandler>> handlersMap = new HashMap<Class, List<StreamMessageHandler>>();
    private String sessionId;
    private int interval = 2000;

    @Inject
    public StreamingServiceImpl(ActionServiceAsync actionService) {
        this.actionService = actionService;
    }

    @Override
    public void addHandler(StreamMessageHandler handler, Class klass) {
        List<StreamMessageHandler> handlers = handlersMap.get(klass);
        if (null == handlers) {
            handlers = new ArrayList<StreamMessageHandler>();
            handlersMap.put(klass, handlers);
        }
        handlers.add(handler);
    }

    @Override
    public void removeHandler(StreamMessageHandler handler, Class klass) {
        List<StreamMessageHandler> handlers = handlersMap.get(klass);
        if (null != handlers) {
            handlers.remove(handler);
        }
    }

    @Override
    public void start() {
        actionService.execute(new StartStreamingAction(interval), new AbstractAsyncCallback<StartStreamingResult>() {

            @Override
            public void onSuccess(final StartStreamingResult result) {
                sessionId = result.getSessionId();
                timer = new Timer() {
                    @Override
                    public void run() {

                        actionService.execute(new GetStreamingMessagesAction(result.getSessionId()), new AsyncCallback<GetStreamingMessagesResult>() {
                            @Override
                            public void onFailure(Throwable caught) {
                                caught.printStackTrace();
                            }

                            @Override
                            public void onSuccess(GetStreamingMessagesResult result) {
                                for (StreamMessage message : result.getStreamMessages()) {
                                    List<StreamMessageHandler> handlers =  handlersMap.get(message.getClass());
                                    if (null != handlers) {
                                        for (StreamMessageHandler handler : handlers) {
                                            handler.handleMessage(message);
                                        }
                                    }
                                }
                            }
                        });
                    }
                };
                timer.scheduleRepeating(interval);
            }
        });
    }

    @Override
    public String getSessionId() {
        return sessionId;
    }
}