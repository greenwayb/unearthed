package com.inventive.system.monitoring.gwt.client.statistics.events;

import com.google.gwt.event.shared.GwtEvent;
import com.inventive.system.monitoring.gwt.client.statistics.dto.Chart;

/**
 * User: grant
 */
public class ChartClosedEvent extends GwtEvent<ChartClosedEventHandler> {

    public static final Type<ChartClosedEventHandler> TYPE = new Type<ChartClosedEventHandler>();

    private Chart chart;

    public ChartClosedEvent(Chart chart) {
        this.chart = chart;
    }

    public Chart getChart() {
        return chart;
    }

    @Override
    public Type<ChartClosedEventHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(ChartClosedEventHandler handler) {
        handler.chartClosed(this);
    }
}
