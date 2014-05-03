package org.unearthed.services;

import com.hazelcast.core.EntryEvent;
import com.hazelcast.core.EntryListener;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.query.SqlPredicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.unearthed.cache.MapNames;

/**
 * User: grant
 */
@Service
public class CacheServiceImpl implements CacheService, MapNames {

    @Autowired
    @Qualifier("hazelcast-unearthed")
    HazelcastInstance hazelcastInstance;

    @SuppressWarnings("unchecked")
    public <K, V> String addContinuousQuery(String cacheName, final CacheListener<K, V> listener, String sql) {

        if (null == sql) {
            return hazelcastInstance.<K, V>getMap(EQUIPMENT_MAP).addEntryListener(new MyEntryListener<K, V>(listener), true);
        } else {
            return hazelcastInstance.<K, V>getMap(EQUIPMENT_MAP).addEntryListener(new MyEntryListener<K, V>(listener), new SqlPredicate(sql), true);
        }
    }

    public <K, V> String addCacheListener(String cacheName, final CacheListener<K, V> listener) {
        return hazelcastInstance.<K, V>getMap(EQUIPMENT_MAP).addEntryListener(new MyEntryListener<K, V>(listener), true);
    }

    private class MyEntryListener<K, V> implements EntryListener<K, V> {

        private CacheListener<K, V> cacheListener;

        private MyEntryListener(CacheListener<K, V> cacheListener) {
            this.cacheListener = cacheListener;
        }

        @Override
        public void entryAdded(EntryEvent<K, V> event) {
            CacheEvent<K, V> cacheEvent = new CacheEvent<K, V>(CacheEventType.ADDED, event.getKey(), event.getOldValue(), event.getValue());
            cacheListener.added(cacheEvent);
        }

        @Override
        public void entryRemoved(EntryEvent<K, V> event) {
            CacheEvent<K, V> cacheEvent = new CacheEvent<K, V>(CacheEventType.REMOVED, event.getKey(), event.getOldValue(), event.getValue());
            cacheListener.added(cacheEvent);
        }

        @Override
        public void entryUpdated(EntryEvent<K, V> event) {
            CacheEvent<K, V> cacheEvent = new CacheEvent<K, V>(CacheEventType.UPDATED, event.getKey(), event.getOldValue(), event.getValue());
            cacheListener.added(cacheEvent);
        }

        @Override
        public void entryEvicted(EntryEvent<K, V> event) {

        }
    }


}
