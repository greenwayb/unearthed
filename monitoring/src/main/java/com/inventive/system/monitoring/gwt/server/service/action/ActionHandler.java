package com.inventive.system.monitoring.gwt.server.service.action;

import com.inventive.system.monitoring.gwt.client.service.action.Action;
import com.inventive.system.monitoring.gwt.client.service.action.Result;

/**
 * User: grant
 */
public interface ActionHandler<A extends Action<R>, R extends Result> {

    /**
     * Executes the business logic for the specified action.
     * @param action the action to execute. May contain parameters the specify or control the business logic that
     * is executed.
     * @return the results of the execution
     */
    R execute(A action);

    Class<A> getActionType();

}