package com.inventive.system.monitoring.server.service.publisher;

import org.springframework.beans.factory.annotation.Required;

import javax.management.openmbean.CompositeData;

/**
 * User: grant
 */
public class MemoryDataConverter implements StatisticConverter<CompositeData, Long> {

    private String field;

    public MemoryDataConverter() {
    }

    @Required
    public void setField(String field) {
        this.field = field;
    }

    @Override
    public Long convert(CompositeData compositeData) {
        return (Long)compositeData.get(field);
    }
}
