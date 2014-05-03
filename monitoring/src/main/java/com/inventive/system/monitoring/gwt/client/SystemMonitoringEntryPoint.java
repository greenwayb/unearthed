package com.inventive.system.monitoring.gwt.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.inventive.system.monitoring.gwt.client.inject.SystemMonitorGinInjector;
import com.inventive.system.monitoring.gwt.client.service.streaming.StreamingService;
import com.inventive.system.monitoring.gwt.client.statistics.LineChartPresenterFactory;

/**
 * Entry point classes define <code>onModuleLoad()</code>
 */
public class SystemMonitoringEntryPoint implements EntryPoint {

//    private Timer timer;
//    private Gauge gauge;

    /**
     * This is the entry point method.
     */
    public void onModuleLoad() {
//        final Button button = new Button("Click me");

        final SystemMonitorGinInjector injector = GWT.create(SystemMonitorGinInjector.class);
        StreamingService streamingService = injector.getStreamingService();
        streamingService.start();

        SystemMonitoringPresenter presenter = injector.getSystemMonitoringPresenter();
        presenter.setLineChartPresenterFactory(new LineChartPresenterFactory(injector));
        RootLayoutPanel.get().add(presenter.getView());
        RootPanel.get("slot1").add(RootLayoutPanel.get());

//        injector.getActionService().execute(new LoginAction("admin", "password"), new AbstractAsyncCallback<LoginResult>() {
//            @Override
//            public void onSuccess(LoginResult result) {
//                UserContainer.setUser(result.getUser());
//                injector.getEventBus().fireEvent(new LoggedInEvent());
//            }
//        });


    }

}
