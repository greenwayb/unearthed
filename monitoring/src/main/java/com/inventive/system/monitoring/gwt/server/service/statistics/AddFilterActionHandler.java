package com.inventive.system.monitoring.gwt.server.service.statistics;

import com.hazelcast.core.EntryEvent;
import com.hazelcast.core.EntryListener;
import com.inventive.system.monitoring.gwt.client.statistics.commands.AddFilterAction;
import com.inventive.system.monitoring.gwt.client.statistics.commands.AddFilterResult;
import com.inventive.system.monitoring.gwt.client.statistics.dto.EventMessage;
import com.inventive.system.monitoring.gwt.client.statistics.dto.GwtEvent;
import com.inventive.system.monitoring.gwt.server.service.action.ActionHandler;
import com.inventive.system.monitoring.gwt.server.service.streaming.StreamingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.unearthed.cache.MapNames;
import org.unearthed.entities.Event;
import org.unearthed.services.CyclesCache;
import org.unearthed.services.EventCache;

/**
 * User: grant
 */
@Service
public class AddFilterActionHandler implements ActionHandler<AddFilterAction, AddFilterResult>, MapNames {

    @Autowired
    private EventCache eventCache;

    @Autowired
    private CyclesCache cyclesCache;

    @Autowired
    private StreamingService streamingService;


    @Override
    public AddFilterResult execute(AddFilterAction action) {

        if (action.getGwtFilterKey().getMapName().equals(EVENT_MAP)) {
            addEventListener(action);
        }
        else if (action.getGwtFilterKey().getMapName().equals(CYCLE_MAP)) {
            addEventListener(action);
        }
        return new AddFilterResult();
    }

    @Override
    public Class<AddFilterAction> getActionType() {
        return AddFilterAction.class;
    }

    private void addEventListener(final AddFilterAction action) {
        if (action.getGwtFilterKey().getQuery() != null) {
            eventCache.addContinuousQuery(new EntryListener<Long, Event>() {
                @Override
                public void entryAdded(EntryEvent<Long, Event> event) {
                    streamingService.sendToSession(action.getGwtFilterKey().getClientId(), new EventMessage(action.getGwtFilterKey(), toGwtEvent(event.getValue())));
                }

                @Override
                public void entryRemoved(EntryEvent<Long, Event> event) {
                }

                @Override
                public void entryUpdated(EntryEvent<Long, Event> event) {
                    streamingService.sendToSession(action.getGwtFilterKey().getClientId(), new EventMessage(action.getGwtFilterKey(), toGwtEvent(event.getValue())));
                }

                @Override
                public void entryEvicted(EntryEvent<Long, Event> event) {

                }
            }, action.getGwtFilterKey().getQuery());
        }  else {
            eventCache.addEntryListener(new EntryListener<Long, Event>() {
                @Override
                public void entryAdded(EntryEvent<Long, Event> event) {
                    streamingService.sendToSession(action.getGwtFilterKey().getClientId(), new EventMessage(action.getGwtFilterKey(), toGwtEvent(event.getValue())));
                }

                @Override
                public void entryRemoved(EntryEvent<Long, Event> event) {
                }

                @Override
                public void entryUpdated(EntryEvent<Long, Event> event) {
                    streamingService.sendToSession(action.getGwtFilterKey().getClientId(), new EventMessage(action.getGwtFilterKey(), toGwtEvent(event.getValue())));
                }

                @Override
                public void entryEvicted(EntryEvent<Long, Event> event) {

                }
            });
        }


    }

    private void addCycleListener(final AddFilterAction action) {
        if (action.getGwtFilterKey().getQuery() != null) {
            cyclesCache.addContinuousQuery(new EntryListener<Long, Event>() {
                @Override
                public void entryAdded(EntryEvent<Long, Event> event) {
                    streamingService.sendToSession(action.getGwtFilterKey().getClientId(), new EventMessage(action.getGwtFilterKey(), toGwtEvent(event.getValue())));
                }

                @Override
                public void entryRemoved(EntryEvent<Long, Event> event) {
                }

                @Override
                public void entryUpdated(EntryEvent<Long, Event> event) {
                    streamingService.sendToSession(action.getGwtFilterKey().getClientId(), new EventMessage(action.getGwtFilterKey(), toGwtEvent(event.getValue())));
                }

                @Override
                public void entryEvicted(EntryEvent<Long, Event> event) {

                }
            }, action.getGwtFilterKey().getQuery());
        }  else {
            cyclesCache.addEntryListener(new EntryListener<Long, Event>() {
                @Override
                public void entryAdded(EntryEvent<Long, Event> event) {
                    streamingService.sendToSession(action.getGwtFilterKey().getClientId(), new EventMessage(action.getGwtFilterKey(), toGwtEvent(event.getValue())));
                }

                @Override
                public void entryRemoved(EntryEvent<Long, Event> event) {
                }

                @Override
                public void entryUpdated(EntryEvent<Long, Event> event) {
                    streamingService.sendToSession(action.getGwtFilterKey().getClientId(), new EventMessage(action.getGwtFilterKey(), toGwtEvent(event.getValue())));
                }

                @Override
                public void entryEvicted(EntryEvent<Long, Event> event) {

                }
            });
        }


    }


    private void addCyclesListener(final AddFilterAction action) {
        if (action.getGwtFilterKey().getQuery() != null) {
            eventCache.addContinuousQuery(new EntryListener<Long, Event>() {
                @Override
                public void entryAdded(EntryEvent<Long, Event> event) {
                    streamingService.sendToSession(action.getGwtFilterKey().getClientId(), new EventMessage(action.getGwtFilterKey(), toGwtEvent(event.getValue())));
                }

                @Override
                public void entryRemoved(EntryEvent<Long, Event> event) {
                }

                @Override
                public void entryUpdated(EntryEvent<Long, Event> event) {
                    streamingService.sendToSession(action.getGwtFilterKey().getClientId(), new EventMessage(action.getGwtFilterKey(), toGwtEvent(event.getValue())));
                }

                @Override
                public void entryEvicted(EntryEvent<Long, Event> event) {

                }
            }, action.getGwtFilterKey().getQuery());
        }  else {
            eventCache.addEntryListener(new EntryListener<Long, Event>() {
                @Override
                public void entryAdded(EntryEvent<Long, Event> event) {
                    streamingService.sendToSession(action.getGwtFilterKey().getClientId(), new EventMessage(action.getGwtFilterKey(), toGwtEvent(event.getValue())));
                }

                @Override
                public void entryRemoved(EntryEvent<Long, Event> event) {
                }

                @Override
                public void entryUpdated(EntryEvent<Long, Event> event) {
                    streamingService.sendToSession(action.getGwtFilterKey().getClientId(), new EventMessage(action.getGwtFilterKey(), toGwtEvent(event.getValue())));
                }

                @Override
                public void entryEvicted(EntryEvent<Long, Event> event) {

                }
            });
        }
    }

    private GwtEvent toGwtEvent(Event in) {
        GwtEvent outValue = new GwtEvent();
        outValue.setDestination(in.getDestination());
        outValue.setEquipment(in.getEquipment());
        outValue.setEventDateTime(in.getEventDateTime());
        outValue.setMeasureCode(in.getMeasureCode());
        outValue.setMeasureValue(in.getMeasureValue());
        outValue.setShKey(in.getShKey());
        outValue.setSite(in.getSite());
        outValue.setSource(in.getSource());
        return outValue;
    }

}
