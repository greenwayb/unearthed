package com.inventive.system.monitoring.gwt.server.service.statistics;

import com.hazelcast.core.EntryEvent;
import com.hazelcast.core.EntryListener;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.query.SqlPredicate;
import com.inventive.system.monitoring.gwt.client.statistics.dto.*;
import com.inventive.system.monitoring.gwt.server.service.streaming.StreamingService;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.unearthed.cache.MapNames;
import org.unearthed.entities.Cycle;
import org.unearthed.entities.Event;

import java.lang.reflect.InvocationTargetException;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * User: grant
 */
@Service
public class EventsFilterManager {

    @Autowired
    private HazelcastInstance hazelcastInstance;

//    @Autowired
//    private EventCache eventCache;

    @Autowired
    private StreamingService streamingService;

    private Map<GwtFilterKey, Set<String>> filterToClientsMap = new ConcurrentHashMap<GwtFilterKey, Set<String>>();
    private Map<GwtFilterKey, String> listenerReferences = new ConcurrentHashMap<GwtFilterKey, String>();

    public void addFilters(String clientId, Collection<GwtFilterKey> keys) {

        for (GwtFilterKey gwtFilterKey : keys) {
            Set<String> clients = filterToClientsMap.get(gwtFilterKey);
            if (clients == null) {
                clients = new HashSet<String>();
                filterToClientsMap.put(gwtFilterKey, clients);
                String id;
                String query = gwtFilterKey.getQuery();
                String cacheName = MapNames.EVENT_MAP;
                String where = query;
                List<String> columns = null;
                if (query.contains("from") && query.contains("select")) {
                    cacheName = getFrom(query);
                    columns = getColumns(query);
                    where = getWhere(query);

                }
                if (StringUtils.isEmpty(where)) {
                    id = hazelcastInstance.getMap(cacheName).addEntryListener(new MyEntryListener(gwtFilterKey, columns), true);
                } else {
                    id = hazelcastInstance.getMap(cacheName).addEntryListener(new MyEntryListener(gwtFilterKey, columns), new SqlPredicate(where), true);
                }
                listenerReferences.put(gwtFilterKey, id);
            }
            clients.add(clientId);

        }

    }

    String getWhere(String query) {
        if (query.contains("where")) {
            return query.substring(query.indexOf("where")+"where".length()).trim();
        }
        return null;
    }

    String getFrom(String query) {
        if (query.contains("where") && query.contains("from")) {
            return query.substring(query.indexOf("from")+"from".length(), query.indexOf("where")).trim();
        }
        return MapNames.EVENT_MAP;
    }

    List<String> getColumns(String query) {
        if (query.contains("select") && query.contains("from")) {
            String fields = query.substring("select".length(), query.indexOf("from"));
            StringTokenizer tokenizer = new StringTokenizer(fields, ",");
            List<String> values = new ArrayList<String>();
            while (tokenizer.hasMoreElements()) {
                values.add(tokenizer.nextToken().trim());
            }
            return values;
        }
        return null;
    }

    public void removeFilters(String clientId, Collection<GwtFilterKey> keys) {

        for (GwtFilterKey gwtFilterKey : keys) {
            Set<String> clients = filterToClientsMap.get(gwtFilterKey);
            if (clients != null) {
                clients.remove(gwtFilterKey);
                if (clients.size() == 0) {
                    String id = listenerReferences.remove(gwtFilterKey);
//                    hazelcastInstance.removeContinuousQuery(id);
                }
            }

        }

    }

    private class MyEntryListener implements EntryListener<Object, Object> {

        private GwtFilterKey gwtFilterKey;
        private List<String> fields;

        private MyEntryListener(GwtFilterKey gwtFilterKey, List<String> fields ) {
            this.gwtFilterKey = gwtFilterKey;
            this.fields = fields;
        }

        @Override
        public void entryAdded(EntryEvent<Object, Object> event) {
            if (fields != null) {
                for (String field : fields) {
                    try {
                        String value = BeanUtils.getProperty(event.getValue(), field);
                        ValueMessage eventMessage = new ValueMessage(gwtFilterKey, value);
                        for (String clientId : filterToClientsMap.get(gwtFilterKey)) {
                            streamingService.sendToSession(clientId, eventMessage);
                        }

                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    } catch (NoSuchMethodException e) {
                        e.printStackTrace();
                    }
                }
            } else {
                if (event.getValue() instanceof Cycle) {
                    CycleMessage eventMessage = new CycleMessage(gwtFilterKey, toGwtCycle((Cycle) event.getValue()));
                    for (String clientId : filterToClientsMap.get(gwtFilterKey)) {
                        streamingService.sendToSession(clientId, eventMessage);
                    }
                }
                else if (event.getValue() instanceof Event) {
                    EventMessage eventMessage = new EventMessage(gwtFilterKey, toGwtEvent((Event)event.getValue()));
                    for (String clientId : filterToClientsMap.get(gwtFilterKey)) {
                        streamingService.sendToSession(clientId, eventMessage);
                    }
                }
            }
        }

        @Override
        public void entryRemoved(EntryEvent<Object, Object> event) {

        }

        @Override
        public void entryUpdated(EntryEvent<Object, Object> event) {
            if (event.getValue() instanceof Cycle) {
                CycleMessage eventMessage = new CycleMessage(gwtFilterKey, toGwtCycle((Cycle) event.getValue()));
                for (String clientId : filterToClientsMap.get(gwtFilterKey)) {
                    streamingService.sendToSession(clientId, eventMessage);
                }
            }
            else if (event.getValue() instanceof Event) {
                EventMessage eventMessage = new EventMessage(gwtFilterKey, toGwtEvent((Event)event.getValue()));
                for (String clientId : filterToClientsMap.get(gwtFilterKey)) {
                    streamingService.sendToSession(clientId, eventMessage);
                }
            }
        }

        @Override
        public void entryEvicted(EntryEvent<Object, Object> event) {

        }
    }

    private GwtEvent toGwtEvent(Event in) {
        GwtEvent event = new GwtEvent();
        toGwtEvent(in, event);
        return event;
    }


    private void toGwtEvent(Event in, GwtEvent outValue) {
        Calendar c = Calendar.getInstance();
        outValue.setDestination(in.getDestination());
        outValue.setEquipment(in.getEquipment());
        outValue.setEventDateTime(in.getEventDateTime());
        outValue.setMeasureCode(in.getMeasureCode());
        outValue.setMeasureValue(in.getMeasureValue());
        outValue.setShKey(in.getShKey());
        outValue.setSite(in.getSite());
        outValue.setSource(in.getSource());
        if (in.getEventDateTime() != null) {
            c.setTime(in.getEventDateTime());
            outValue.setHours(c.get(Calendar.HOUR));
            outValue.setMinutes(c.get(Calendar.MINUTE));
            outValue.setSeconds(c.get(Calendar.SECOND));
        }
    }

    private GwtCycle toGwtCycle(Cycle in) {
        GwtCycle cycle = new GwtCycle();
        toGwtEvent(in, cycle);
        cycle.setDurationLoading(in.getDurationLoading());
        cycle.setDurationQueueing(in.getDurationQueueing());
        cycle.setDurationTravelEmpty(in.getDurationTravelEmpty());
        cycle.setDurationTravelLoaded(in.getDurationTravelLoaded());


        return cycle;
    }



}
