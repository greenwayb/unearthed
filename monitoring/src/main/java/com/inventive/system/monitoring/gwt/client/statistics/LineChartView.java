package com.inventive.system.monitoring.gwt.client.statistics;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.*;
import com.google.gwt.visualization.client.DataTable;
import com.google.gwt.visualization.client.visualizations.corechart.LineChart;
import com.google.gwt.visualization.client.visualizations.corechart.Options;

/**
 */
public class LineChartView implements LineChartPresenter.View {

    interface MyUiBinder extends UiBinder<VerticalPanel, LineChartView> {}
    private static MyUiBinder uiBinder = GWT.create(MyUiBinder.class);

    @UiField(provided = true)
    ChartWrapper chartWrapper;

    private LineChart lineChart;

    public LineChartView() {
        init();
    }

    private void init() {
        chartWrapper = new ChartWrapper();
        uiBinder.createAndBindUi(this);
    }

    @Override
    public Widget asWidget() {
        return chartWrapper;
    }

    @Override
    public void setHeader(IsWidget widget) {
        chartWrapper.add(widget);
    }

    @Override
    public LineChart createChart(Options options, DataTable data) {
        if (lineChart != null) {
            chartWrapper.remove(lineChart);
            lineChart = null;
        }
        lineChart = new LineChart(data, options);
        chartWrapper.add(lineChart);
        return lineChart;
    }
}
