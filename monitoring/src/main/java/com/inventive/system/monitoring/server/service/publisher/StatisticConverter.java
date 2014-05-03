package com.inventive.system.monitoring.server.service.publisher;

/**
 * User: grant
 */
public interface StatisticConverter<IN, OUT> {

    public OUT convert(IN in);
}
