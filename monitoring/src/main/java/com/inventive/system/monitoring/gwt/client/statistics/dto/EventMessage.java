package com.inventive.system.monitoring.gwt.client.statistics.dto;

import com.inventive.system.monitoring.gwt.client.service.streaming.StreamMessage;

/**
 * User: grant
 */
public class EventMessage implements StreamMessage {

    private GwtEvent event;
    private GwtFilterKey gwtFilterKey;

    private EventMessage() {
    }

    public EventMessage(GwtFilterKey key, GwtEvent event) {
        this.gwtFilterKey = key;
        this.event = event;
    }

    public GwtEvent getEvent() {
        return event;
    }

    public GwtFilterKey getGwtFilterKey() {
        return gwtFilterKey;
    }
}
