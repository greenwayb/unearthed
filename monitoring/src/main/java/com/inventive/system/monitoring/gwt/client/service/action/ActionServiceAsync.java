package com.inventive.system.monitoring.gwt.client.service.action;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface ActionServiceAsync {

    public <R extends Result> void execute(Action<R> action, AsyncCallback<R> async);

}
