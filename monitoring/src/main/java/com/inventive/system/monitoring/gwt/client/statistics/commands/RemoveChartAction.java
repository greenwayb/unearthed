package com.inventive.system.monitoring.gwt.client.statistics.commands;

import com.inventive.system.monitoring.gwt.client.service.action.Action;
import com.inventive.system.monitoring.gwt.client.statistics.dto.Chart;

/**
 * User: grant
 */
public class RemoveChartAction implements Action<RemoveChartResult> {

    private Chart chart;

    private RemoveChartAction() {

    }

    public RemoveChartAction(Chart chart) {
        this.chart = chart;
    }

    public Chart getChart() {
        return chart;
    }
}
