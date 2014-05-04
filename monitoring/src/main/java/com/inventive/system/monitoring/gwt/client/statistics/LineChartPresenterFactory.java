package com.inventive.system.monitoring.gwt.client.statistics;

import com.inventive.system.monitoring.gwt.client.inject.SystemMonitorGinInjector;

/**
 * User: grant
 */
public class LineChartPresenterFactory {

    private SystemMonitorGinInjector injector;

    public LineChartPresenterFactory(SystemMonitorGinInjector injector) {
        this.injector = injector;
    }

    public LineChartPresenter newLineChartPresenter() {
        return injector.getLineChartPresenter();
    }

    public LineChartPresenter newCycleLineChartPresenter() {
        return injector.getLineChartPresenter();
    }

}
