package com.inventive.system.monitoring.gwt.client.statistics.commands;

import com.inventive.system.monitoring.gwt.client.service.action.Result;
import com.inventive.system.monitoring.gwt.client.statistics.dto.Chart;

import java.util.ArrayList;

/**
 * User: grant
 */
public class GetChartsResult implements Result {

    private ArrayList<Chart> charts;

    public GetChartsResult() {
    }

    public GetChartsResult(ArrayList<Chart> charts) {
        this.charts = charts;
    }

    public ArrayList<Chart> getCharts() {
        return charts;
    }
}
