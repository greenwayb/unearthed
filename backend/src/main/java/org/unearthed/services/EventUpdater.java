package org.unearthed.services;

import com.hazelcast.core.HazelcastInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.unearthed.cache.MapNames;
import org.unearthed.entities.Event;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * User: grant
 */
@Service
public class EventUpdater implements MapNames{

    private ExecutorService executorService;

    @Autowired
    private HazelcastInstance hazelcastInstance;

    @PersistenceContext
    private EntityManager entityManager;


    @Autowired
    private DataSource dataSource;

    private JdbcTemplate jdbcTemplate;

    @PostConstruct
    public void start() {

        jdbcTemplate = new JdbcTemplate(dataSource);

        executorService = Executors.newSingleThreadExecutor();


        List<Map<String, Object>> eventsMap = jdbcTemplate.queryForList("select\n" +
                "shkey,\n" +
                "Equipment,\n" +
                "Location as 'Source',\n" +
                "Destn as 'Destination',\n" +
                "Meascode,\n" +
                "Measurevalue\n" +
                "from\n" +
                "alloctntimestamp a\n" +
                "join\n" +
                "measuretimestamp m on a.tskey = m.tskey where\n" +
                "Meascode = 'TONNE' and \n" +
                "m.eventDateTime >= cast('2013-05-01' as DATE) and m.eventDateTime < cast('2013-05-10' AS DATE)");

        for (Map<String, Object> eventMap : eventsMap) {
            final Event event = new Event();
            event.setShKey((String)eventMap.get("SHKey"));
            event.setEquipment((String)eventMap.get("equipment"));
            event.setSource((String) eventMap.get("location"));
            event.setDestination((String) eventMap.get("destn"));
            event.setMeasureCode((String)eventMap.get("Meascode"));
            event.setMeasureValue(new BigDecimal((Double)eventMap.get("measurevalue")));
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    hazelcastInstance.<String, Event>getMap(EVENT_MAP).put(event.getShKey(), event);
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }

    }

    @PreDestroy
    public void stop() {
        if (null != executorService) {
            executorService.shutdownNow();
        }
    }
}
