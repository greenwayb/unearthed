package com.inventive.system.monitoring.gwt.client.service.action;

import com.google.gwt.core.client.GWT;
import com.google.inject.Provider;

/**
 * User: grant
 */
public class ActionServiceProvider implements Provider<ActionServiceAsync> {

    private CachingActionServiceAsync cachingActionService;

    @Override
    public ActionServiceAsync get() {
        if (null == cachingActionService) {
            ActionServiceAsync actionService = (ActionServiceAsync) GWT.create(ActionService.class);
            cachingActionService = new CachingActionServiceAsync(actionService);
        }
        return cachingActionService;
    }
}