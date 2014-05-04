package com.inventive.system.monitoring.gwt.client.statistics.dto;


/**
 * User: grant
 */
public class CycleMessage extends EventMessage {

    private GwtCycle event;
    private GwtFilterKey gwtFilterKey;

    private CycleMessage() {
    }

    public CycleMessage(GwtFilterKey key, GwtCycle event) {
        this.gwtFilterKey = key;
        this.event = event;
    }

    public GwtCycle getEvent() {
        return event;
    }

    public GwtFilterKey getGwtFilterKey() {
        return gwtFilterKey;
    }
}
