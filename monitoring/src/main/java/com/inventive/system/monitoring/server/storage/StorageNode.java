package com.inventive.system.monitoring.server.storage;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 */
public class StorageNode {

    private static Log log = LogFactory.getLog(StorageNode.class);

    public static void main(String args[]) {
        new ClassPathXmlApplicationContext("com/inventive/system/monitoring/server/storage/applicationContext.xml");

        if (log.isInfoEnabled()) {
            log.info("Storage node started");
        }

    }
}
