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
import java.math.MathContext;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicLong;

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

    private AtomicLong atomicLong = new AtomicLong(0);

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
                "Measurevalue,\n" +
                "m.EventDateTime as 'EventDateTime'\n" +
                "from\n" +
                "alloctntimestamp a\n" +
                "join\n" +
                "measuretimestamp m on a.tskey = m.tskey where\n" +
                "Meascode = 'TONNE' and \n" +
                "m.eventDateTime >= cast('2013-06-01' as DATE) and m.eventDateTime < cast('2013-06-10' AS DATE)");

        for (Map<String, Object> eventMap : eventsMap) {
            final Event event = new Event();
            event.setShKey((String)eventMap.get("SHKey"));
            event.setEquipment((String) eventMap.get("equipment"));
            event.setSource((String) eventMap.get("source"));
            event.setDestination((String) eventMap.get("destination"));
            event.setMeasureCode((String) eventMap.get("Meascode"));
            event.setMeasureValue(new BigDecimal((Double) eventMap.get("measurevalue"), new MathContext(2)));
            event.setEventDateTime((Date)eventMap.get("EventDateTime"));
            executorService.execute(new Runnable() {
                @Override
                public void run() {

                    System.out.println(event);
                    hazelcastInstance.<Long, Event>getMap(EVENT_MAP).put(atomicLong.getAndIncrement(), event);
                    try {
                        Thread.sleep(1000);
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
