package com.inventive.system.monitoring.gwt.client.statistics.dto;

import com.inventive.system.monitoring.gwt.client.service.streaming.StreamMessage;

/**
 * User: grant
 */
public class ValueMessage implements StreamMessage {

    private String value;
    private GwtFilterKey gwtFilterKey;

    public ValueMessage() {
    }

    public ValueMessage(GwtFilterKey gwtFilterKey, String value) {
        this.gwtFilterKey = gwtFilterKey;
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public GwtFilterKey getGwtFilterKey() {
        return gwtFilterKey;
    }
}
