package com.inventive.system.monitoring.gwt.client.statistics.events;

import com.google.gwt.event.shared.GwtEvent;
import com.inventive.system.monitoring.gwt.client.statistics.dto.GwtFilterKey;

import java.util.Set;

/**
 * User: grant
 */
public class AddChartEvent extends GwtEvent<AddChartEventHandler> {

    public static final Type<AddChartEventHandler> TYPE = new Type<AddChartEventHandler>();

    private Set<GwtFilterKey> keys;

    public AddChartEvent(Set<GwtFilterKey> keys) {
        this.keys = keys;
    }


    public Set<GwtFilterKey> getKeys() {
        return keys;
    }

    @Override
    public Type<AddChartEventHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(AddChartEventHandler handler) {
        handler.onAddChart(this);
    }

}
