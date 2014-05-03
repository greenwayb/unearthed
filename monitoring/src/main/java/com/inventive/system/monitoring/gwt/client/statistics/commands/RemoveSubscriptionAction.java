package com.inventive.system.monitoring.gwt.client.statistics.commands;

import com.inventive.system.monitoring.gwt.client.service.action.Action;
import com.inventive.system.monitoring.gwt.client.statistics.dto.JmxStatisticKey;

import java.util.List;

/**
 * User: grant
 */
public class RemoveSubscriptionAction implements Action<RemoveSubscriptionResult> {

    private List<JmxStatisticKey> jmxStatisticKeys;
    private String streamingSessionId;

    @SuppressWarnings("UnusedDeclaration")
    private RemoveSubscriptionAction() {
    }

    public RemoveSubscriptionAction(List<JmxStatisticKey> jmxStatisticKeys, String streamingSessionId) {
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
