package org.unearthed.webservices.rest;

import com.google.gson.Gson;
import org.glassfish.jersey.media.sse.EventOutput;
import org.glassfish.jersey.media.sse.OutboundEvent;
import org.glassfish.jersey.media.sse.SseFeature;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;
import org.unearthed.cache.MapNames;
import org.unearthed.entities.Event;
import org.unearthed.services.EventCache;

import javax.annotation.PostConstruct;
import javax.ws.rs.*;
import java.io.IOException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Path("unearthed")
@Service
public class Unearthed implements MapNames, ApplicationContextAware {

    private Gson gson;

    private static ApplicationContext applicationContext;

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
    @Consumes("application/json")
    public void event(String json) {

        Event event = gson.fromJson(json, Event.class);
        getEventCache().putEvent(event);
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
//            new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    try {
//                        for (int i = 0; i < 10; i++) {
//                            // ... code that waits 1 second
//                            final OutboundEvent.Builder eventBuilder
//                                    = new OutboundEvent.Builder();
//                            eventBuilder.name("message-to-client");
//                            eventBuilder.data(String.class,
//                                    "Hello world " + i + "!");
//                            final OutboundEvent event = eventBuilder.build();
//                            eventOutput.write(event);
//                        }
//                    } catch (IOException e) {
//                        throw new RuntimeException(
//                                "Error when writing the event.", e);
//                    } catch (Exception e) {
//                        throw new RuntimeException(
//                                "Error when writing the event.", e);
//                    } finally {
//                        try {
//                            eventOutput.close();
//                        } catch (IOException ioClose) {
//                            throw new RuntimeException(
//                                    "Error when closing the event output.", ioClose);
//                        }
//                    }
//                }
//            }).start();
            ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
            scheduledExecutorService.scheduleAtFixedRate(new Runnable() {

                long x = 0 ;
                @Override
                public void run() {
                    try {
                        final OutboundEvent.Builder eventBuilder
                                = new OutboundEvent.Builder();
                        eventBuilder.name("message-to-client");
                        eventBuilder.data(String.class,
                                "Hello world " + (x++) + "!");
                        final OutboundEvent event = eventBuilder.build();
                        eventOutput.write(event);
                    } catch (Exception e) {
                        try {
                            eventOutput.close();
                        } catch (IOException e1) {
                            e1.printStackTrace();
                        }
                    }
                }
            }, 1, 1, TimeUnit.SECONDS);
            return eventOutput;
        }
    }

}
