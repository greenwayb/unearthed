package com.inventive.system.monitoring.gwt.client.dialog;

import com.google.gwt.event.shared.GwtEvent;

/**
 * User: grant
 */
public class OkEvent extends GwtEvent<OkHandler> {

    public static Type<OkHandler> TYPE = new Type<OkHandler>();

    @Override
    public Type<OkHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(OkHandler handler) {
        handler.onOk(this);
    }
}
