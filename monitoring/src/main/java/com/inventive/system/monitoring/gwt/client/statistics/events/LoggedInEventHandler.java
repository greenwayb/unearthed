package com.inventive.system.monitoring.gwt.client.statistics.events;

import com.google.gwt.event.shared.EventHandler;

/**
 * User: grant
 */
public interface LoggedInEventHandler extends EventHandler {

    public void onLoggedIn(LoggedInEvent event);
}
