package com.inventive.system.monitoring.gwt.client.inject;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.inject.client.GinModules;
import com.google.gwt.inject.client.Ginjector;
import com.inventive.system.monitoring.gwt.client.SystemMonitoringPresenter;
import com.inventive.system.monitoring.gwt.client.dnd.DragDropGridPresenter;
import com.inventive.system.monitoring.gwt.client.service.action.ActionServiceAsync;
import com.inventive.system.monitoring.gwt.client.service.streaming.StreamingService;
import com.inventive.system.monitoring.gwt.client.statistics.LineChartPresenter;

/**
 * User: grant
 */
@GinModules(SystemMonitorModule.class)
public interface SystemMonitorGinInjector extends Ginjector {

    ActionServiceAsync getActionService();
    StreamingService getStreamingService();
    SystemMonitoringPresenter getSystemMonitoringPresenter();
    LineChartPresenter getLineChartPresenter();
    EventBus getEventBus();
//    DescriptorsPresenter getPublishersPresenter();
    DragDropGridPresenter getDragDropGridPresenter();

}
