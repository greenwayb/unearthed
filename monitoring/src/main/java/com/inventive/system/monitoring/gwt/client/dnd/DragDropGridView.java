package com.inventive.system.monitoring.gwt.client.dnd;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;

/**
 * User: grant
 */
public class DragDropGridView implements DragDropGridPresenter.View {

    interface MyUiBinder extends UiBinder<FlexTable, DragDropGridView> {}
    private static MyUiBinder uiBinder = GWT.create(MyUiBinder.class);

    @UiField
    FlexTable flexTable;

    private DragDropController dragDropController;

    public DragDropGridView() {
        init();
    }

    private void init() {
        uiBinder.createAndBindUi(this);
    }

    @Override
    public Widget asWidget() {
        return flexTable;
    }

    public void setDragDropController(DragDropController dragDropController) {
        this.dragDropController = dragDropController;
    }

    @Override
    public void addContainer(int row, int col) {
        DragDropContainer dragDropContainer = new DragDropContainer();
        dragDropController.addDroppable(dragDropContainer);
        flexTable.setWidget(row, col, dragDropContainer);
    }

    @Override
    public void addWidget(int row, int col, IsWidget widget) {
        widget.asWidget().getElement().setDraggable(Element.DRAGGABLE_TRUE);
        dragDropController.addDraggable(widget);

        DragDropContainer container = (DragDropContainer)flexTable.getWidget(row, col);
        container.setWidget(widget);
    }

    @Override
    public void removeWidget(int row, int col) {
        DragDropContainer container = (DragDropContainer)flexTable.getWidget(row, col);
        container.clear();
    }

    @Override
    public boolean isEmpty(int row, int col) {
        DragDropContainer container = (DragDropContainer)flexTable.getWidget(row, col);
        return container.getWidget(0) == null;
    }
}
