package com.inventive.system.monitoring.gwt.client.statistics;

import com.google.gwt.event.shared.EventBus;
import com.google.inject.ImplementedBy;
import com.google.inject.Inject;
import com.inventive.system.monitoring.gwt.client.mvp.AbstractMvpPresenter;
import com.inventive.system.monitoring.gwt.client.mvp.MvpView;
import com.inventive.system.monitoring.gwt.client.service.action.ActionServiceAsync;

/**
 * User: grant
 */
public class TruckerPresenter extends AbstractMvpPresenter<TruckerPresenter.View> {

    @ImplementedBy(TruckerView.class)
    public static interface View extends MvpView {

    }

    @Inject
    public TruckerPresenter(TruckerPresenter.View view,
                                     ActionServiceAsync actionServiceAsync,
                                     EventBus eventBus) {
        super(view);

    }

    public void init() {

    }


}
