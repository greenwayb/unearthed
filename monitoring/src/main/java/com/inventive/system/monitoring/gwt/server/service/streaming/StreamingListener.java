package com.inventive.system.monitoring.gwt.server.service.streaming;

import com.inventive.system.monitoring.gwt.client.statistics.dto.JmxStatisticKey;
import com.inventive.system.monitoring.server.service.publisher.Subscription;

/**
 * User: grant
 */
public interface StreamingListener {

    Subscription addSubscriber(String sessionId, JmxStatisticKey jmxStatisticKey);
    void removeSubscriber(String sessionId, JmxStatisticKey jmxStatisticKey);
}
