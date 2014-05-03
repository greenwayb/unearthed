package com.inventive.system.monitoring.gwt.client.service.action;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.user.client.rpc.AsyncCallback;

import java.util.HashMap;
import java.util.Map;

/**
 * User: grant
 */
public class CachingActionServiceAsync implements ActionServiceAsync {

    private ActionServiceAsync service;
    private Map<Action<?>, Object> cache;

    public CachingActionServiceAsync(ActionServiceAsync service) {
        this.service = service;
        cache = new HashMap<Action<?>, Object>();
    }

    @Override
    public <R extends Result> void execute(final Action<R> action, final AsyncCallback<R> callback) {
        if (action instanceof Cacheable) {
            @SuppressWarnings({"unchecked"})
//            GWT.log("Attempting to retrieve action " + action.getClass().getName() + " from cache.");
            final R result = (R)cache.get(action);
            if (null == result) {
//                GWT.log("Object not retrieved from cache " + action.getClass().getName());
                service.execute(action, new AsyncCallback<R>() {
                    @Override
                    public void onFailure(Throwable throwable) {
//                        GWT.log("Failed to execute action " + action.getClass().getName(), throwable);
                        callback.onFailure(throwable);
                    }

                    @Override
                    public void onSuccess(R r) {
                        cache.put(action, r);
                        callback.onSuccess(r);
                    }
                });
            } else {
//                GWT.log("Object retrieved from cache " + action.getClass().getName());
                Scheduler scheduler = Scheduler.get();
                scheduler.scheduleDeferred(new Scheduler.ScheduledCommand() {
                    @Override
                    public void execute() {
                        callback.onSuccess(result);
                    }
                });
            }
        } else {
//            GWT.log("Executing action: " + action.toString() + "; callback: " + callback.toString());
            service.execute(action,new AsyncCallback<R>() {
                @Override
                public void onFailure(Throwable caught) {
//                    GWT.log("Failed to execute action " + action.getClass().getName(), caught);
                    callback.onFailure(caught);
                }

                @Override
                public void onSuccess(R result) {
                    callback.onSuccess(result);
                }
            });
        }
    }
}
