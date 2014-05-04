package org.unearthed.services;

import com.hazelcast.core.HazelcastInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.unearthed.cache.MapNames;
import org.unearthed.entities.Cycle;
import org.unearthed.entities.Event;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicLong;

/**
 * User: grant
 */
@Service
public class CyclesUpdater implements MapNames{

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
                "Truck as Equipment,\n" +
                "Location as 'Source',\n" +
                "Destn as 'Destination',\n" +
                "Quantity as measurevalue,\n" +
                "DurationLoading as DurationLoading,\n" +
                "DurationQueueing as DurationQueueing,\n" +
                "DurationTravelEmpty as DurationTravelEmpty,\n" +
                "DurationTravelLoaded as DurationTravelLoaded\n" +
                "from\n" +
                "cycles a\n" +
                "join\n" +
                "measuretimestamp m on a.tskey = m.tskey where\n" +
                "Meascode = 'TONNE' and \n" +
                "m.eventDateTime >= cast('2013-06-01' as DATE) and m.eventDateTime < cast('2013-06-10' AS DATE)");

        for (Map<String, Object> eventMap : eventsMap) {
            final Cycle cycle = new Cycle();
            cycle.setShKey((String) eventMap.get("SHKey"));
            cycle.setEquipment((String) eventMap.get("equipment"));
            cycle.setSource((String) eventMap.get("source"));
            cycle.setDestination((String) eventMap.get("destination"));
            cycle.setDurationLoading(new BigDecimal((Double) eventMap.get("durationloading"), new MathContext(2)));
            cycle.setDurationQueueing(new BigDecimal((Double) eventMap.get("DurationQueueing"), new MathContext(2)));
            cycle.setDurationTravelEmpty(new BigDecimal((Double) eventMap.get("DurationTravelEmpty"), new MathContext(2)));
            cycle.setDurationTravelLoaded(new BigDecimal((Double) eventMap.get("DurationTravelLoaded"), new MathContext(2)));
            executorService.execute(new Runnable() {
                @Override
                public void run() {

                    hazelcastInstance.<Long, Event>getMap(CYCLE_MAP).put(atomicLong.getAndIncrement(), cycle);
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
