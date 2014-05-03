package com.inventive.system.monitoring.gwt.client.statistics;

import com.inventive.system.monitoring.gwt.client.service.streaming.NumberStatisticMessage;

/**
 * User: grant
 */
public interface HasStatistic {

    void update(NumberStatisticMessage message);
}
