package com.inventive.system.monitoring.gwt.client.inject;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.inject.client.AbstractGinModule;
import com.google.inject.Singleton;
import com.inventive.system.monitoring.gwt.client.service.action.ActionServiceAsync;
import com.inventive.system.monitoring.gwt.client.service.action.ActionServiceProvider;
import com.inventive.system.monitoring.gwt.client.service.streaming.StreamingService;
import com.inventive.system.monitoring.gwt.client.service.streaming.StreamingServiceImpl;

/**
 * User: grant
 */
public class SystemMonitorModule extends AbstractGinModule {

    @Override
    protected void configure() {
        bind(ActionServiceAsync.class).toProvider(ActionServiceProvider.class).in(Singleton.class);
        bind(StreamingService.class).to(StreamingServiceImpl.class).in(Singleton.class);
        bind(EventBus.class).to(SimpleEventBus.class).in(Singleton.class);
    }
}
