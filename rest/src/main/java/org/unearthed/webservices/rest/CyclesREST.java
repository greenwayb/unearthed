package org.unearthed.webservices.rest;

import com.google.gson.Gson;
import com.hazelcast.core.EntryEvent;
import com.hazelcast.core.EntryListener;
import org.glassfish.jersey.media.sse.EventOutput;
import org.glassfish.jersey.media.sse.OutboundEvent;
import org.glassfish.jersey.media.sse.SseFeature;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;
import org.unearthed.cache.MapNames;
import org.unearthed.entities.Event;
import org.unearthed.entities.RegisterQuery;
import org.unearthed.entities.UnregisterQuery;
import org.unearthed.services.CyclesCache;

import javax.annotation.PostConstruct;
import javax.ws.rs.*;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

@Path("unearthed")
@Service
public class CyclesREST implements MapNames, ApplicationContextAware {

    private static Gson gson = new Gson();

    private static ApplicationContext applicationContext;

    private Map<String, Set<String>> clientListeners = new HashMap<String, Set<String>>();
    private static Map<String, List<Event>> clientCycles = new HashMap<String, List<Event>>();

    public static Map<String, List<Event>> getClientCycles() {
        return clientCycles;
    }

    @PostConstruct
    public void init() {
        registerListenerGet("1");
    }

    @GET
    @Consumes("text/plain")
    public String hello() {
        return "Hello";
    }

    @POST
    @Path("SendEvent")
    @Consumes("application/json")
    public void event(String json) {

        Event event = gson.fromJson(json, Event.class);
        getCyclesCache().putEvent(event);

    }

    @POST
    @Path("UnregisterListener")
    @Consumes("application/json")
    public void unregisterListener(String json) {

        UnregisterQuery unregisterQuery = gson.fromJson(json, UnregisterQuery.class);

        Set<String> listeners = clientListeners.get(unregisterQuery.getClientId());
        if (null != listeners) {
            listeners.remove(unregisterQuery.getListenerId());
        }
        getCyclesCache().removeContinuousQuery(unregisterQuery.getListenerId());
    }

    @GET
    @Path("UnregisterListenerGet")
    @Consumes("text/plain")
    public void unregisterListenerGet(String json) {

        UnregisterQuery unregisterQuery = gson.fromJson(json, UnregisterQuery.class);

        Set<String> listeners = clientListeners.get(unregisterQuery.getClientId());
        if (null != listeners) {
            listeners.remove(unregisterQuery.getListenerId());
        }
        getCyclesCache().removeContinuousQuery(unregisterQuery.getListenerId());
    }



    @POST
    @Path("RegisterListener")
    @Consumes("application/json")
    @Produces("application/json")
    public String registerListener(String json) {

        final RegisterQuery registerQuery = gson.fromJson(json, RegisterQuery.class);
        String id;
        if (null == registerQuery.getQuery() || registerQuery.getQuery().length() == 0) {
            id =  getCyclesCache().addEntryListener(new EntryListener<Long, Event>() {
                @Override
                public void entryAdded(EntryEvent<Long, Event> event) {
                    List<Event> events = clientCycles.get(registerQuery.getClientId());
                    if (events == null) {
                        events = new CopyOnWriteArrayList<Event>();
                    }
                    events.add(event.getValue());
                    clientCycles.put(registerQuery.getClientId(), events);
                }

                @Override
                public void entryRemoved(EntryEvent<Long, Event> event) {
                    List<Event> events = clientCycles.get(registerQuery.getClientId());
                    if (events != null) {
                        events.remove(event.getValue());
                        clientCycles.put(registerQuery.getClientId(), events);
                    }
                }

                @Override
                public void entryUpdated(EntryEvent<Long, Event> event) {
                    List<Event> events = clientCycles.get(registerQuery.getClientId());
                    if (events == null) {
                        events = new CopyOnWriteArrayList<Event>();
                    }
                    events.add(event.getValue());
                    clientCycles.put(registerQuery.getClientId(), events);
                }

                @Override
                public void entryEvicted(EntryEvent<Long, Event> event) {

                }
            });
        } else {
            id =  getCyclesCache().addContinuousQuery(new EntryListener<Long, Event>() {
                @Override
                public void entryAdded(EntryEvent<Long, Event> event) {
                    List<Event> events = clientCycles.get(registerQuery.getClientId());
                    if (events == null) {
                        events = new CopyOnWriteArrayList<Event>();
                    }
                    events.add(event.getValue());
                    clientCycles.put(registerQuery.getClientId(), events);
                }

                @Override
                public void entryRemoved(EntryEvent<Long, Event> event) {
                    List<Event> events = clientCycles.get(registerQuery.getClientId());
                    if (events != null) {
                        events.remove(event.getValue());
                        clientCycles.put(registerQuery.getClientId(), events);
                    }
                }

                @Override
                public void entryUpdated(EntryEvent<Long, Event> event) {
                    List<Event> events = clientCycles.get(registerQuery.getClientId());
                    if (events == null) {
                        events = new CopyOnWriteArrayList<Event>();
                    }
                    events.add(event.getValue());
                    clientCycles.put(registerQuery.getClientId(), events);
                }

                @Override
                public void entryEvicted(EntryEvent<Long, Event> event) {

                }
            }, registerQuery.getQuery());
        }
        Set<String> ids = clientListeners.get(id);
        if (null == ids) {
            ids = new HashSet<String>();
        }
        ids.add(id);
        clientListeners.put(registerQuery.getClientId(), ids);
        return gson.toJson(id);



    }

    @GET
    @Path("RegisterListenerGet")
    @Consumes("text/plain")
    @Produces("text/plain")
    public String registerListenerGet(final String clientId) {

            String id =  getCyclesCache().addEntryListener(new EntryListener<Long, Event>() {
                @Override
                public void entryAdded(EntryEvent<Long, Event> event) {
                    List<Event> events = clientCycles.get(clientId);
                    if (events == null) {
                        events = new CopyOnWriteArrayList<Event>();
                    }
                    events.add(event.getValue());
                    clientCycles.put(clientId, events);
                }

                @Override
                public void entryRemoved(EntryEvent<Long, Event> event) {
                    List<Event> events = clientCycles.get(clientId);
                    if (events != null) {
                        events.remove(event.getValue());
                        clientCycles.put(clientId, events);
                    }
                }

                @Override
                public void entryUpdated(EntryEvent<Long, Event> event) {
                    List<Event> events = clientCycles.get(clientId);
                    if (events == null) {
                        events = new CopyOnWriteArrayList<Event>();
                    }
                    events.add(event.getValue());
                    clientCycles.put(clientId, events);
                }

                @Override
                public void entryEvicted(EntryEvent<Long, Event> event) {

                }
            });
        Set<String> ids = clientListeners.get(id);
        if (null == ids) {
            ids = new HashSet<String>();
        }
        ids.add(id);
        clientListeners.put(clientId, ids);
        return id;



    }



    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    private CyclesCache getCyclesCache() {
        return applicationContext.getBean(CyclesCache.class);
    }

    private ClientRegister getClientRegister() {
        return applicationContext.getBean(ClientRegister.class);
    }


    @Path("GetEvents")
    @Produces("application/json")
    @Consumes("text/plain")
    @GET
    public String getEvents(String clientId) {
        List<Event> eventList  = CyclesREST.getClientCycles().get(0);
        if (null != eventList) {
            String result = gson.toJson(eventList);
            eventList.clear();
            return result;
        }
        return null;
    }


    @Path("events")
    public static class SseResource {

        @GET
        @Produces(SseFeature.SERVER_SENT_EVENTS)
        public EventOutput getServerSentEvents() {
            final EventOutput eventOutput = new EventOutput();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        if (CyclesREST.getClientCycles().size() > 0) {
                            List<Event> eventList  = CyclesREST.getClientCycles().get(0);
                            if (null != eventList) {
                                Iterator<Event> iterator = eventList.iterator();
                                while (iterator.hasNext()) {
                                    Event event = iterator.next();
                                    iterator.remove();
                                    final OutboundEvent.Builder eventBuilder
                                            = new OutboundEvent.Builder();
                                    eventBuilder.name("event");
                                    eventBuilder.data(Event.class, gson.toJson(event));
                                    final OutboundEvent outboundEvent = eventBuilder.build();
                                    eventOutput.write(outboundEvent);
                                }
                            }
                        }

                    } catch (IOException e) {
                        throw new RuntimeException(
                                "Error when writing the event.", e);
                    } catch (Exception e) {
                        throw new RuntimeException(
                                "Error when writing the event.", e);
                    } finally {
                        try {
                            eventOutput.close();
                        } catch (IOException ioClose) {
                            throw new RuntimeException(
                                    "Error when closing the event output.", ioClose);
                        }
                    }
                }
            }).start();
            return eventOutput;
        }
    }

}
