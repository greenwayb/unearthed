package com.inventive.system.monitoring.gwt.client.statistics.events;

import com.google.gwt.event.shared.GwtEvent;

/**
 * User: grant
 */
public class LoggedInEvent extends GwtEvent<LoggedInEventHandler> {

    public static final Type<LoggedInEventHandler> TYPE = new Type<LoggedInEventHandler>();

    @Override
    public Type<LoggedInEventHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(LoggedInEventHandler handler) {
        handler.onLoggedIn(this);
    }
}
