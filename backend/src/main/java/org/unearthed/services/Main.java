package org.unearthed.services;

import com.google.gson.Gson;
import com.hazelcast.core.EntryEvent;
import com.hazelcast.core.EntryListener;
import com.hazelcast.core.HazelcastInstance;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.unearthed.cache.MapNames;
import org.unearthed.entities.Event;

/**
 * User: grant
 */
public class Main implements MapNames {

    private static Gson gson;

    public static void main(String args[]) {
        gson = new Gson();
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("backend-application-context.xml");

        HazelcastInstance instance = applicationContext.getBean(HazelcastInstance.class);
        instance.<Long, Event>getMap(EVENT_MAP).addEntryListener(new EntryListener<Long, Event>() {

            @Override
            public void entryAdded(EntryEvent<Long, Event> event) {
                System.out.println("Event added " + event);
            }

            @Override
            public void entryRemoved(EntryEvent<Long, Event> event) {
                System.out.println("Event removed " + event);
            }

            @Override
            public void entryUpdated(EntryEvent<Long, Event> event) {
                System.out.println("Event updated " + event);
            }

            @Override
            public void entryEvicted(EntryEvent<Long, Event> event) {

            }
        }, true);

    }

    private static String toJson(Object object) {
        return gson.toJson(object);
    }
}
