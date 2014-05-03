package com.inventive.system.monitoring.gwt.client.dnd;

import com.allen_sauer.gwt.dnd.client.DragContext;
import com.allen_sauer.gwt.dnd.client.VetoDragException;
import com.allen_sauer.gwt.dnd.client.drop.AbstractDropController;
import com.allen_sauer.gwt.dnd.client.drop.DropController;
import com.google.gwt.user.client.ui.Widget;

/**
 */
public class GridConstrainedDropController extends AbstractDropController implements DropController {

    public GridConstrainedDropController(Widget dropTarget) {
        super(dropTarget);
    }

    @Override
    public void onDrop(DragContext context) {
        super.onDrop(context);
    }

    @Override
    public void onEnter(DragContext context) {
        super.onEnter(context);
    }

    @Override
    public void onLeave(DragContext context) {
        super.onLeave(context);
    }

    @Override
    public void onMove(DragContext context) {
        super.onMove(context);
    }

    @Override
    public void onPreviewDrop(DragContext context) throws VetoDragException {
        super.onPreviewDrop(context);
    }
}
