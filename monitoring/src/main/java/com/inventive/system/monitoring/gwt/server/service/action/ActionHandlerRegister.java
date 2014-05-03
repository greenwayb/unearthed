package com.inventive.system.monitoring.gwt.server.service.action;

/**
 * User: grant
 */
import com.inventive.system.monitoring.gwt.client.service.action.Action;
import com.inventive.system.monitoring.gwt.client.service.action.Result;

/**
 * @author grantlittle
 *
 */
public interface ActionHandlerRegister {

	public <R extends Result> ActionHandler<Action<R>, R> getHandler(Action<R> action);
}
