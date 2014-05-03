package com.inventive.system.monitoring.gwt.server.service.statistics;

import com.inventive.system.monitoring.gwt.client.statistics.dto.JmxStatisticKey;
import com.inventive.system.monitoring.gwt.client.statistics.commands.RemoveSubscriptionAction;
import com.inventive.system.monitoring.gwt.client.statistics.commands.RemoveSubscriptionResult;
import com.inventive.system.monitoring.gwt.server.service.action.ActionHandler;
import com.inventive.system.monitoring.gwt.server.service.streaming.StreamingListener;
import com.inventive.system.monitoring.server.service.publisher.MapNames;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * User: grant
 */
@Service
public class RemoveSubscriptionActionHandler implements ActionHandler<RemoveSubscriptionAction, RemoveSubscriptionResult>, MapNames {

    @Autowired
    private StreamingListener streamingListener;

    public RemoveSubscriptionActionHandler() {
    }

    @Override
    public RemoveSubscriptionResult execute(RemoveSubscriptionAction action) {

        for (JmxStatisticKey key : action.getJmxStatisticKeys()) {
            streamingListener.removeSubscriber(action.getStreamingSessionId(), key);
        }
        return new RemoveSubscriptionResult();
    }

    @Override
    public Class<RemoveSubscriptionAction> getActionType() {
        return RemoveSubscriptionAction.class;
    }
}
