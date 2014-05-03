package com.inventive.system.monitoring.gwt.client.dnd;

import com.google.gwt.dom.client.Style;
import com.google.gwt.event.dom.client.*;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.user.client.ui.HasOneWidget;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;

/**
 * User: grant
 */
public class DragDropController implements DragStartHandler, DropHandler, DragEndHandler, DragLeaveHandler, DragOverHandler {

    private Widget dragging;

    private EventBus eventBus = new SimpleEventBus();



    public HandlerRegistration addDraggable(final IsWidget widget) {
        final HandlerRegistration startReg = widget.asWidget().addDomHandler(this, DragStartEvent.getType());


        return new HandlerRegistration() {
            @Override
            public void removeHandler() {
                startReg.removeHandler();
            }
        };
    }

    public HandlerRegistration addDroppable(final IsWidget widget) {
        final HandlerRegistration  dropReg = widget.asWidget().addDomHandler(this, DropEvent.getType());
        final HandlerRegistration  dragOverReg = widget.asWidget().addDomHandler(this, DragOverEvent.getType());
        final HandlerRegistration  dragOverLeave = widget.asWidget().addDomHandler(this, DragLeaveEvent.getType());


        return new HandlerRegistration() {
            @Override
            public void removeHandler() {
                dropReg.removeHandler();
                dragOverReg.removeHandler();
                dragOverLeave.removeHandler();
            }
        };
    }

    @Override
    public void onDragStart(DragStartEvent event) {
        dragging = (Widget)event.getSource();

        event.setData("text", "hi there");

        event.getDataTransfer()
                .setDragImage(dragging.getElement(), 10, 10);

    }

    @Override
    public void onDrop(DropEvent event) {
        event.preventDefault();
        Object source = event.getSource();
        if (source instanceof HasWidgets) {
            HasWidgets hasWidgets = (HasWidgets)source;
            hasWidgets.add(dragging);
        }
        else if (source instanceof HasOneWidget) {
            HasOneWidget hasOneWidget = (HasOneWidget)source;
            hasOneWidget.setWidget(dragging);
        }
        Widget target = (Widget)event.getSource();
        target.getElement().getStyle().setBorderStyle(Style.BorderStyle.NONE);

        eventBus.fireEvent(new WidgetMovedEvent(target));
        eventBus.fireEvent(new WidgetMovedEvent(target));

    }

    public HandlerRegistration addWidgetMovedHandler(WidgetMovedHandler handler) {
        return eventBus.addHandler(WidgetMovedEvent.TYPE, handler);
    }

    @Override
    public void onDragEnd(DragEndEvent event) {
        Widget target = (Widget)event.getSource();
        target.getElement().getStyle().setBorderStyle(Style.BorderStyle.NONE);
        dragging.removeFromParent();
        dragging = null;
    }



    @Override
    public void onDragLeave(DragLeaveEvent event) {
        Widget target = (Widget)event.getSource();
        target.getElement().getStyle().setBorderStyle(Style.BorderStyle.NONE);

    }

    @Override
    public void onDragOver(DragOverEvent event) {
        Widget target = (Widget)event.getSource();
        target.getElement().getStyle().setBorderStyle(Style.BorderStyle.DASHED);
        target.getElement().getStyle().setBorderColor("lightgray");
    }


}
