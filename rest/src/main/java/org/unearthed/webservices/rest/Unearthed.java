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
import org.unearthed.services.EventCache;

import javax.annotation.PostConstruct;
import javax.ws.rs.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Path("unearthed")
@Service
public class Unearthed implements MapNames, ApplicationContextAware {

    private Gson gson;

    private static ApplicationContext applicationContext;

    private Map<String, Set<String>> clientListeners = new HashMap<String, Set<String>>();
    private Map<String, Event> clientEvents = new HashMap<String, Event>();

    @PostConstruct
    public void init() {
        this.gson = new Gson();
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
        getEventCache().putEvent(event);

    }

    @POST
    @Path("RegisterListener")
    @Consumes("application/json")
    public void unregisterListener(String json) {

        String id = gson.fromJson(json, String.class);

        clientListeners.remove(id);

        getEventCache().removeContinuousQuery(id);

    }


    @POST
    @Path("RegisterListener")
    @Consumes("application/json")
    @Produces("application/json")
    public String registerListener(String json) {

        final RegisterQuery registerQuery = gson.fromJson(json, RegisterQuery.class);


        String id =  getEventCache().addContinuousQuery(new EntryListener<Long, Event>() {
            @Override
            public void entryAdded(EntryEvent<Long, Event> event) {
                clientEvents.put(registerQuery.getClientId(), event.getValue());
            }

            @Override
            public void entryRemoved(EntryEvent<Long, Event> event) {
                clientEvents.remove(registerQuery.getClientId(), event.getValue());
            }

            @Override
            public void entryUpdated(EntryEvent<Long, Event> event) {
                clientEvents.put(registerQuery.getClientId(), event.getValue());
            }

            @Override
            public void entryEvicted(EntryEvent<Long, Event> event) {

            }
        },  registerQuery.getQuery());
        Set<String> ids = clientListeners.get(id);
        if (null == ids) {
            ids = new HashSet<String>();
        }
        ids.add(id);
        clientListeners.put(registerQuery.getClientId(), ids);
        return gson.toJson(id);

    }


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    private EventCache getEventCache() {
        return applicationContext.getBean(EventCache.class);
    }

    private ClientRegister getClientRegister() {
        return applicationContext.getBean(ClientRegister.class);
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
                        for (int i = 0; i < 10; i++) {
//                            Thread.sleep(1000);
                            final OutboundEvent.Builder eventBuilder
                                    = new OutboundEvent.Builder();
                            eventBuilder.name("message-to-client");
                            eventBuilder.data(String.class,
                                    "Hello world " + i + "!");
                            final OutboundEvent event = eventBuilder.build();
                            eventOutput.write(event);
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
