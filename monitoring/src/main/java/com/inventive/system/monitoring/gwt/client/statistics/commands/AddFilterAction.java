package com.inventive.system.monitoring.gwt.client.statistics.commands;

import com.inventive.system.monitoring.gwt.client.service.action.Action;
import com.inventive.system.monitoring.gwt.client.statistics.dto.GwtFilterKey;

import java.util.Collection;

/**
 * User: grant
 */
public class AddFilterAction implements Action<AddFilterResult> {

    private String clientId;
    private Collection<GwtFilterKey> gwtFilterKeys;

    protected AddFilterAction() {
    }

    public AddFilterAction(String clientId, Collection<GwtFilterKey> gwtFilterKeys) {
        this.gwtFilterKeys = gwtFilterKeys;
        this.clientId = clientId;
    }

    public Collection<GwtFilterKey> getGwtFilterKeys() {
        return gwtFilterKeys;
    }

    public String getClientId() {
        return clientId;
    }
}
