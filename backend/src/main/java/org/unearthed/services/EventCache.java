package org.unearthed.services;

import com.hazelcast.core.EntryListener;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.query.SqlPredicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.unearthed.cache.MapNames;
import org.unearthed.entities.Event;

import java.util.concurrent.atomic.AtomicLong;

/**
 * User: grant
 */
@Service
public class EventCache implements MapNames {

    private AtomicLong atomicLong = new AtomicLong(0);

    @Autowired
    HazelcastInstance hazelcastInstance;

    public void putEvent(Event event) {
        hazelcastInstance.<Long, Event>getMap(EVENT_MAP).put(atomicLong.getAndIncrement(), event);
    }

    public String  addEntryListener(EntryListener<Long, Event> entryListener) {
        return hazelcastInstance.<Long, Event>getMap(EVENT_MAP).addEntryListener(entryListener, true);
    }

    public String addContinuousQuery(EntryListener<Long, Event> entryListener, String sql) {
        return hazelcastInstance.<Long, Event>getMap(EVENT_MAP).addEntryListener(entryListener, new SqlPredicate(sql), true);
    }

    public void removeContinuousQuery(String id) {
        hazelcastInstance.<Long, Event>getMap(EVENT_MAP).removeEntryListener(id);
    }

}
