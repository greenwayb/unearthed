package com.inventive.system.monitoring.server.service.publisher;

import com.hazelcast.core.HazelcastInstance;
import com.inventive.system.monitoring.gwt.client.statistics.dto.ResetMessage;
import com.inventive.system.monitoring.gwt.server.service.streaming.StreamingService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Required;

/**
 * User: grant
 */
public class ResetJob implements MapNames {

    private static Log log = LogFactory.getLog(ResetJob.class);

    private StreamingService streamingService;

    private HazelcastInstance hazelcastInstance;

    public void reset() {
        if (log.isInfoEnabled()) {
            log.info("Resetting charts");
        }
        hazelcastInstance.getMap(STATISTICS_MAP).clear();
        streamingService.sendToAll(new ResetMessage());

    }

    @Required
    public void setStreamingService(StreamingService streamingService) {
        this.streamingService = streamingService;
    }

    @Required
    public void setHazelcastInstance(HazelcastInstance hazelcastInstance) {
        this.hazelcastInstance = hazelcastInstance;
    }
}
