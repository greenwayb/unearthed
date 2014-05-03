package com.inventive.system.monitoring.gwt.client.service.action;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("handler/ActionService")
public interface ActionService extends RemoteService {

	public <R extends Result> R execute(Action<R> action);

}
