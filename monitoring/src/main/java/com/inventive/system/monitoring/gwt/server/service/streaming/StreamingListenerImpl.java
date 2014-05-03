package com.inventive.system.monitoring.gwt.server.service.streaming;

import com.hazelcast.core.EntryEvent;
import com.hazelcast.core.EntryListener;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;
import com.hazelcast.query.EntryObject;
import com.hazelcast.query.PredicateBuilder;
import com.inventive.system.monitoring.gwt.client.service.streaming.NumberStatisticMessage;
import com.inventive.system.monitoring.gwt.client.statistics.dto.JmxStatisticKey;
import com.inventive.system.monitoring.gwt.server.service.statistics.ConversionUtils;
import com.inventive.system.monitoring.server.service.publisher.MapNames;
import com.inventive.system.monitoring.server.service.publisher.StatisticEntry;
import com.inventive.system.monitoring.server.service.publisher.StatisticKey;
import com.inventive.system.monitoring.server.service.publisher.Subscription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.Serializable;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * User: grant
 */
@Service
public class StreamingListenerImpl implements MapNames, StreamingListener {

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    @Qualifier("hazelcast-unearthed")
    private HazelcastInstance hazelcastInstance;

    @Autowired
    private StreamingService streamingService;

    private ExecutorService executorService = Executors.newCachedThreadPool();

    private Map<JmxStatisticKey, Set<SubscriptionCount>> subscriptions = new HashMap<JmxStatisticKey, Set<SubscriptionCount>>();

    @PostConstruct
    public void init() {
        IMap<StatisticKey, StatisticEntry> statisticsMap = hazelcastInstance.getMap(STATISTICS_MAP);
        statisticsMap.addEntryListener(new EntryListener<StatisticKey, StatisticEntry>() {
            @Override
            public void entryAdded(EntryEvent<StatisticKey, StatisticEntry> event) {
                processEvent(event.getKey(), event.getValue());
            }

            @Override
            public void entryRemoved(EntryEvent<StatisticKey, StatisticEntry> event) {
            }

            @Override
            public void entryUpdated(EntryEvent<StatisticKey, StatisticEntry> event) {
                processEvent(event.getKey(), event.getValue());
            }

            @Override
            public void entryEvicted(EntryEvent<StatisticKey, StatisticEntry> event) {
            }
        }, true);
    }

    private void processEvent(StatisticKey key, StatisticEntry entry) {
        Set<SubscriptionCount> ids = subscriptions.get(ConversionUtils.toJmxStatisticKey(key));

        if (null != ids) {
            for (SubscriptionCount id : ids) {
                NumberStatisticMessage message =
                        new NumberStatisticMessage(
                                ConversionUtils.toJmxStatisticKey(key),
                                new ArrayList<NumberStatisticMessage.TimeAndValue>(Collections.singletonList(new NumberStatisticMessage.TimeAndValue(entry.getDate(),
                                (Number)entry.getValue()))));
                streamingService.sendToSession(id.getSessionId(), message);
            }
        }
    }



    @Override
    public Subscription addSubscriber(final String sessionId, final JmxStatisticKey jmxStatisticKey) {

        //Send all existing data to the streaming client
        executorService.execute(new Runnable() {
            @Override
            public void run() {


                IMap<StatisticKey, StatisticEntry> map = hazelcastInstance.getMap(STATISTICS_MAP);
                PredicateBuilder builder = new PredicateBuilder();
                EntryObject entryObject = builder.getEntryObject();

                PredicateBuilder predicate = entryObject.get("objectName").equal(jmxStatisticKey.getObjectName());
                predicate = predicate.and(entryObject.get("propertyName").equal(jmxStatisticKey.getPropertyName()));
                if (jmxStatisticKey.getProcessName() != null) {
                    predicate = predicate.and(entryObject.get("processName").equal(jmxStatisticKey.getProcessName()));
                }
                if (jmxStatisticKey.getMachineName() != null) {
                    predicate = predicate.and(entryObject.get("machineName").equal(jmxStatisticKey.getMachineName()));
                }
                if (jmxStatisticKey.getFieldName() != null) {
                    predicate = predicate.and(entryObject.get("fieldName").equal(jmxStatisticKey.getFieldName()));
                }

                List<StatisticEntry> entries = new ArrayList<StatisticEntry>(map.values(predicate));
                Collections.sort(entries, new Comparator<StatisticEntry>() {
                    @Override
                    public int compare(StatisticEntry statisticEntry, StatisticEntry statisticEntry2) {
                        return statisticEntry.getDate().compareTo(statisticEntry2.getDate());
                    }
                });

                Map<JmxStatisticKey, ArrayList<NumberStatisticMessage.TimeAndValue>> valuesMap = new HashMap<JmxStatisticKey, ArrayList<NumberStatisticMessage.TimeAndValue>>();
                for (StatisticEntry entry : entries) {
                    JmxStatisticKey key = ConversionUtils.toJmxStatisticKey(entry);
                    ArrayList<NumberStatisticMessage.TimeAndValue> values = valuesMap.get(key);
                    if (null == values) {
                        values = new ArrayList<NumberStatisticMessage.TimeAndValue>(entries.size());
                        valuesMap.put(key, values);
                    }
                    values.add(new NumberStatisticMessage.TimeAndValue(entry.getDate(), (Number)entry.getValue()));
                }

                for (Map.Entry<JmxStatisticKey, ArrayList<NumberStatisticMessage.TimeAndValue>> entry : valuesMap.entrySet()) {

                    ArrayList<NumberStatisticMessage.TimeAndValue> values = entry.getValue();

                    Collections.sort(values);

                    NumberStatisticMessage message =
                            new NumberStatisticMessage(
                                    jmxStatisticKey,
                                    values);
                    streamingService.sendToSession(sessionId, message);
                }


                Set<SubscriptionCount> ids = subscriptions.get(jmxStatisticKey);
                if (null == ids) {
                    ids = new HashSet<SubscriptionCount>();
                    subscriptions.put(jmxStatisticKey, ids);
                }
                ids.add(new SubscriptionCount(sessionId));



            }
        });

        return new Subscription();
    }

    @Override
    public void removeSubscriber(String sessionId, JmxStatisticKey jmxStatisticKey) {
        Set<SubscriptionCount> ids = subscriptions.get(jmxStatisticKey);
        if (null != ids) {
            Iterator<SubscriptionCount> itr = ids.iterator();
            while (itr.hasNext()) {
                SubscriptionCount subscriptionCount = itr.next();
                if (subscriptionCount.getSessionId().equals(sessionId)) {
                    if (subscriptionCount.getCount().decrementAndGet() == 0) {
                        itr.remove();
                    }
                }
            }
        }
    }

    public static class SubscriptionCount implements Serializable {

        private String sessionId;
        private AtomicInteger count;

        public SubscriptionCount(String sessionId) {
            this.sessionId = sessionId;
            count = new AtomicInteger(1);
        }

        public String getSessionId() {
            return sessionId;
        }

        public AtomicInteger getCount() {
            return count;
        }
    }
}
