package com.inventive.system.monitoring.gwt.client.dnd;

import com.google.gwt.user.client.ui.IsWidget;
import com.google.inject.ImplementedBy;
import com.google.inject.Inject;
import com.inventive.system.monitoring.gwt.client.mvp.AbstractMvpPresenter;
import com.inventive.system.monitoring.gwt.client.mvp.MvpView;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * User: grant
 */
public class DragDropGridPresenter extends AbstractMvpPresenter<DragDropGridPresenter.View> {



    @ImplementedBy(DragDropGridView.class)
    public static interface View extends MvpView {
        void addContainer(int row, int col);
        void addWidget(int row, int col, IsWidget widget);
        void removeWidget(int row, int col);
        boolean isEmpty(int row, int col);
        void setDragDropController(DragDropController dragDropController);
    }

    private int MAX_ROW = 3;
    private int MAX_COL = 3;
    private int col = 0;
    private int row = 0;

    private Set<XY> locations = new HashSet<XY>();

    private Map<IsWidget, HasPosition> widgetPositions = new HashMap<IsWidget, HasPosition>();


    private DragDropController dragDropController;

    @Inject
    public DragDropGridPresenter(View view) {
        super(view);
        init();
    }

    private void init() {

        dragDropController = new DragDropController();

        dragDropController.addWidgetMovedHandler(new WidgetMovedHandler() {
            @Override
            public void onWidgetMoved(WidgetMovedEvent event) {

            }
        });

        getView().setDragDropController(dragDropController);
        for (int row = 0; row < MAX_COL; row++) {
            for (int col=0; col<MAX_ROW; col++) {
                getView().addContainer(row, col);
            }
        }
    }



    public void addWidget(IsWidget widget, HasPosition hasPosition) {

        if (null != hasPosition) {
            if (locations.contains(new XY(hasPosition.getRow(), hasPosition.getColumn()))) {
                if (getView().isEmpty(hasPosition.getRow(), hasPosition.getColumn())) {
                    getView().addWidget(hasPosition.getRow(), hasPosition.getColumn(), widget);
                    locations.add(new XY(hasPosition.getRow(), hasPosition.getColumn()));
                    return;
                }
            }
        }
        addWidgetToNextAvailableSlot(widget, hasPosition);
    }

    private void addWidgetToNextAvailableSlot(IsWidget widget, HasPosition hasPosition) {
        if (col >= MAX_COL) {
            col =0;
            row++;
        }

        getView().addWidget(row, col, widget);

        hasPosition.setPosition(row, col);
        locations.add(new XY(hasPosition.getRow(), hasPosition.getColumn()));
        col++;

    }

    public void removeWidget(IsWidget widget, HasPosition hasPosition) {
        if (!getView().isEmpty(hasPosition.getRow(), hasPosition.getColumn())) {
            getView().removeWidget(hasPosition.getRow(), hasPosition.getColumn());
            locations.remove(new XY(hasPosition.getRow(), hasPosition.getColumn()));
        }
    }

    private class XY {
        private int x=0;
        private int y=0;

        public XY(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            XY xy = (XY) o;

            if (x != xy.x) return false;
            if (y != xy.y) return false;

            return true;
        }

        @Override
        public int hashCode() {
            int result = x;
            result = 31 * result + y;
            return result;
        }
    }

}
