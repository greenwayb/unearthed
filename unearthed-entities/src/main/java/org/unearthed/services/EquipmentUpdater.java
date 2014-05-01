package org.unearthed.services;

import com.hazelcast.core.HazelcastInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.unearthed.cache.MapNames;
import org.unearthed.entities.Equipment;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.UUID;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * User: grant
 */
@Service
public class EquipmentUpdater  implements MapNames{

    private ScheduledExecutorService executorService;

    @Autowired
    private HazelcastInstance hazelcastInstance;

    @PostConstruct
    public void start() {
        executorService = Executors.newScheduledThreadPool(1);
        executorService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                Equipment equipment = new Equipment();
                equipment.setEquipmentId(1L);
                equipment.setEquipmentCapacity(UUID.randomUUID().toString());
                equipment.setEquipmentModel("CAT950");

                hazelcastInstance.<Long, Equipment>getMap(EQUIPMENT_MAP).put(1L, equipment);
            }
        }, 1000, 1000, TimeUnit.MILLISECONDS);
    }

    @PreDestroy
    public void stop() {
        if (null != executorService) {
            executorService.shutdownNow();
        }
    }
}
