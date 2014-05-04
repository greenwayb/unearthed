package com.inventive.system.monitoring.gwt.server.service.statistics;

import com.inventive.system.monitoring.gwt.client.statistics.commands.AddFilterAction;
import com.inventive.system.monitoring.gwt.client.statistics.commands.AddFilterResult;
import com.inventive.system.monitoring.gwt.server.service.action.ActionHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.unearthed.cache.MapNames;

/**
 * User: grant
 */
@Service
public class AddFilterActionHandler implements ActionHandler<AddFilterAction, AddFilterResult>, MapNames {

    @Autowired
    private EventsFilterManager eventsFilterManager;


    @Override
    public AddFilterResult execute(AddFilterAction action) {
        eventsFilterManager.addFilters(action.getClientId(), action.getGwtFilterKeys());
        return new AddFilterResult();
    }

    @Override
    public Class<AddFilterAction> getActionType() {
        return AddFilterAction.class;
    }

}
