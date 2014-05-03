package com.inventive.system.monitoring.gwt.client.mvp;

import com.google.gwt.event.shared.HandlerRegistration;

import java.util.ArrayList;
import java.util.List;

/**
 * User: Grant Little <grant.little@inventivesoftware.com.au>
 */
public abstract class AbstractMvpPresenter<V extends MvpView> implements MvpPresenter {

    protected V view;
    private List<HandlerRegistration> handlerRegistrations;

    protected AbstractMvpPresenter(V view) {
        this.view = view;
        this.handlerRegistrations = new ArrayList<HandlerRegistration>();
    }

    @Override
    public V getView() {
        return view;
    }


    protected void registerHandler(HandlerRegistration reg) {
        handlerRegistrations.add(reg);
    }

}
