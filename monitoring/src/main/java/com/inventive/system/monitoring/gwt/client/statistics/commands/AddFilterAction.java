package com.inventive.system.monitoring.gwt.client.statistics.commands;

import com.inventive.system.monitoring.gwt.client.service.action.Action;
import com.inventive.system.monitoring.gwt.client.statistics.dto.GwtFilterKey;

/**
 * User: grant
 */
public class AddFilterAction implements Action<AddFilterResult> {

    private GwtFilterKey gwtFilterKey;

    protected AddFilterAction() {
    }

    public AddFilterAction(GwtFilterKey gwtFilterKey) {
        this.gwtFilterKey = gwtFilterKey;
    }

    public GwtFilterKey getGwtFilterKey() {
        return gwtFilterKey;
    }
}
