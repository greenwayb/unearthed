package com.inventive.system.monitoring.gwt.client.statistics.commands;

import com.inventive.system.monitoring.gwt.client.service.action.Action;
import com.inventive.system.monitoring.gwt.client.statistics.dto.JmxStatisticKey;

import java.util.List;

/**
 * User: grant
 */
public class AddSubscriptionAction implements Action<AddSubscriptionResult> {

    private List<JmxStatisticKey> jmxStatisticKeys;
    private String streamingSessionId;

    @SuppressWarnings("UnusedDeclaration")
    private AddSubscriptionAction() {
    }

    public AddSubscriptionAction(List<JmxStatisticKey> jmxStatisticKeys, String streamingSessionId) {
        this.jmxStatisticKeys = jmxStatisticKeys;
        this.streamingSessionId = streamingSessionId;
    }

    public List<JmxStatisticKey> getJmxStatisticKeys() {
        return jmxStatisticKeys;
    }

    public String getStreamingSessionId() {
        return streamingSessionId;
    }
}
