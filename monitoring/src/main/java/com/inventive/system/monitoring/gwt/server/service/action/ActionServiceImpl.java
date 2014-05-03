package com.inventive.system.monitoring.gwt.server.service.action;

import com.inventive.system.monitoring.gwt.client.service.action.Action;
import com.inventive.system.monitoring.gwt.client.service.action.ActionService;
import com.inventive.system.monitoring.gwt.client.service.action.Result;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

//@Service
public class ActionServiceImpl implements ActionService {

	private static final Logger log = Logger.getLogger(ActionServiceImpl.class);


    protected ActionHandlerRegister actionHandlerRegister;

    @Autowired
	public void setActionHandlerRegister(ActionHandlerRegister actionHandlerRegister) {
		this.actionHandlerRegister = actionHandlerRegister;
	}

	@SuppressWarnings({"unchecked"})
    public <R extends Result> R execute(Action<R> action) {
    	if (log.isDebugEnabled()) log.debug("Entering method execute() with action type " + action.getClass().getName());
        ActionHandler handler = actionHandlerRegister.getHandler(action);
        if (null == handler) {
        	throw new RuntimeException("No handler registered for Action type " + action.getClass().getName());
        }
        try {
            R result = (R)handler.execute(action);
            return result;
        }
        catch (Exception ex) {
            log.error(action.getClass().getName(), ex);
            throw new RuntimeException(ex);
        }
    }


}
