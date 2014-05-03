package org.unearthed.webservices.rest;

import com.google.gson.Gson;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;
import org.unearthed.cache.MapNames;
import org.unearthed.entities.Event;
import org.unearthed.services.EventCache;

import javax.annotation.PostConstruct;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

@Path("unearthed")
@Service
public class UnearthedEndpoint implements MapNames, ApplicationContextAware {

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

}
