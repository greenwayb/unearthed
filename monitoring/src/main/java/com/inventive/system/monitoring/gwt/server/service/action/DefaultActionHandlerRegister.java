package com.inventive.system.monitoring.gwt.server.service.action;

import com.inventive.system.monitoring.gwt.client.service.action.Action;
import com.inventive.system.monitoring.gwt.client.service.action.Result;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Service
public class DefaultActionHandlerRegister implements ActionHandlerRegister, ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public DefaultActionHandlerRegister() {
    }

    /**
     * Map of action class to handler.
     * Note: Due to some GWT/Generics issues no generic types are used for ActionHandler.
     */
    @SuppressWarnings("unchecked")
	private Map<Class<? extends Action>, ActionHandler> actionHandlerMappings;

//    @SuppressWarnings("unchecked")
//    public void setHandlerMappings(List<ActionHandler<Action<?>, ?>> handlers) {
//        actionHandlerMappings = new HashMap<Class<? extends Action>, ActionHandler>();
//        for (ActionHandler<Action<?>, ?> handler : handlers) {
//            actionHandlerMappings.put(handler.getActionType(), handler);
//        }
//    }

    @PostConstruct
    public void init() {
        actionHandlerMappings = new HashMap<Class<? extends Action>, ActionHandler>();
        Map<String, ActionHandler> handlers = applicationContext.getBeansOfType(ActionHandler.class);
        for (ActionHandler<Action<?>, ?> handler : handlers.values()) {
            actionHandlerMappings.put(handler.getActionType(), handler);
        }

    }




    @Override
    @SuppressWarnings("unchecked")
    public <R extends Result> ActionHandler<Action<R>, R> getHandler(Action<R> action) {

        return (ActionHandler<Action<R>, R>) actionHandlerMappings.get(action.getClass());
    }




}
