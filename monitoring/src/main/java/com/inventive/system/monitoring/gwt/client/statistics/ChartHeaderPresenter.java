package com.inventive.system.monitoring.gwt.client.statistics;

import com.allen_sauer.gwt.dnd.client.HasDragHandle;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.HasHTML;
import com.google.inject.ImplementedBy;
import com.google.inject.Inject;
import com.inventive.system.monitoring.gwt.client.mvp.AbstractMvpPresenter;
import com.inventive.system.monitoring.gwt.client.mvp.MvpView;

/**
 * User: grant
 */
public class ChartHeaderPresenter extends AbstractMvpPresenter<ChartHeaderPresenter.View> {

    @ImplementedBy(ChartHeaderView.class)
    public static interface View extends MvpView, HasDragHandle {
        HasHTML getTitle();
        HasClickHandlers getEdit();
        HasClickHandlers getClose();

    }

    @Inject
    public ChartHeaderPresenter(View view) {
        super(view);
        init();
    }

    private void init() {
    }

    public void setTitle(String title) {
        getView().getTitle().setHTML(title);
    }

    HasClickHandlers getEdit() {
        return getView().getEdit();
    }

    HasClickHandlers getClose() {
        return getView().getClose();
    }

    public HasDragHandle getDragHandle() {
        return getView();
    }
}
