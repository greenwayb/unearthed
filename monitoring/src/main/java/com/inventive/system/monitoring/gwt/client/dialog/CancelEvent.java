package com.inventive.system.monitoring.gwt.client.dialog;

import com.google.gwt.event.shared.GwtEvent;

/**
 * User: grant
 */
public class CancelEvent extends GwtEvent<CancelHandler> {

    public static Type<CancelHandler> TYPE = new Type<CancelHandler>();

    @Override
    public Type<CancelHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(CancelHandler handler) {
        handler.onCancel(this);
    }
}
