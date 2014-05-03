package com.inventive.system.monitoring.gwt.client.service.action;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * User: grant
 */
public abstract class AbstractAsyncCallback<T> implements AsyncCallback<T> {

    @Override
    public void onFailure(Throwable caught) {
        caught.printStackTrace();
    }
}
