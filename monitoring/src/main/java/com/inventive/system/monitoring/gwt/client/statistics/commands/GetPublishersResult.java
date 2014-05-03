package com.inventive.system.monitoring.gwt.client.statistics.commands;

import com.inventive.system.monitoring.gwt.client.service.action.Result;
import com.inventive.system.monitoring.gwt.client.statistics.dto.GwtStatisticDescriptor;

import java.util.Set;

/**
 * User: grant
 */
public class GetPublishersResult implements Result {

    private Set<GwtStatisticDescriptor> gwtStatisticDescriptors;

    @SuppressWarnings("UnusedDeclaration")
    private GetPublishersResult() {
    }

    public GetPublishersResult(Set<GwtStatisticDescriptor> gwtStatisticDescriptors) {
        this.gwtStatisticDescriptors = gwtStatisticDescriptors;
    }

    public Set<GwtStatisticDescriptor> getGwtStatisticDescriptors() {
        return gwtStatisticDescriptors;
    }
}
