package com.inventive.system.monitoring.server.service.publisher;

import com.hazelcast.core.HazelcastInstance;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * User: grant
 */
public class ExternalStatisticsPublisherMain {

    private static Log log = LogFactory.getLog(ExternalStatisticsPublisherMain.class);


    public static void main(String args[]) {
        new ExternalStatisticsPublisherMain();
    }

    @SuppressWarnings("unchecked")
    public ExternalStatisticsPublisherMain() {
        new ClassPathXmlApplicationContext("com/inventive/system/monitoring/server/publisher/applicationContext.xml");

        if (log.isInfoEnabled()) {
            log.info("Storage node started");
        }
    }
}
