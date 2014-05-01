package org.unearthed.cache.mapstore;

import com.hazelcast.core.MapStore;
import org.unearthed.entities.Equipment;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.*;

/**
 * User: grant
 */
public class EquipmentMapStore implements MapStore<Long, Equipment> {

    private static Map<Long, Equipment> store = new HashMap<Long, Equipment>();

    @PersistenceContext
    private EntityManager entityManager;

    public EquipmentMapStore() {
    }

    @Override
    public void store(Long key, Equipment value) {

        entityManager.persist(value);
        store.put(key, value);
    }

    @Override
    public void storeAll(Map<Long, Equipment> map) {
        map.putAll(map);
    }

    @Override
    public void delete(Long key) {
        store.remove(key);

    }

    @Override
    public void deleteAll(Collection<Long> keys) {
        for (Long key : keys) {
            store.remove(key);
        }
    }

    @Override
    public Equipment load(Long key) {
        return store.get(key);
    }

    @Override
    public Map<Long, Equipment> loadAll(Collection<Long> keys) {
        Map<Long, Equipment> map = new HashMap<Long, Equipment>();
        for (Long key : keys) {
            map.put(key, store.get(key));
        }
        return map;
    }

    @Override
    public Set<Long> loadAllKeys() {

        TypedQuery<Long> query =  entityManager.createQuery("select e.equipmentId from Equipment e", Long.class);
        List<Long> keys =query.getResultList();
        Set<Long> result = new HashSet<Long>(keys.size());
        result.addAll(keys);
        return result;

//        return store.keySet();
    }
}
