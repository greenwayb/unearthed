package com.inventive.system.monitoring.gwt.client.dnd;

import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.user.client.ui.Widget;

/**
 * User: grant
 */
public class WidgetMovedEvent extends GwtEvent<WidgetMovedHandler> {

    public static Type<WidgetMovedHandler> TYPE = new Type<WidgetMovedHandler>();

    private Widget widget;

    public WidgetMovedEvent(Widget widget) {
        this.widget = widget;
    }

    public Widget getWidget() {
        return widget;
    }

    @Override
    public Type<WidgetMovedHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(WidgetMovedHandler handler) {
        handler.onWidgetMoved(this);
    }
}
