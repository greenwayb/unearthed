package com.inventive.system.monitoring.gwt.server.service.statistics;

import com.inventive.system.monitoring.gwt.client.statistics.dto.JmxStatisticKey;
import com.inventive.system.monitoring.gwt.client.statistics.commands.AddSubscriptionAction;
import com.inventive.system.monitoring.gwt.client.statistics.commands.AddSubscriptionResult;
import com.inventive.system.monitoring.gwt.server.service.action.ActionHandler;
import com.inventive.system.monitoring.server.service.publisher.MapNames;
import com.inventive.system.monitoring.gwt.server.service.streaming.StreamingListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * User: grant
 */
@Service
public class AddSubscriptionActionHandler implements ActionHandler<AddSubscriptionAction, AddSubscriptionResult>, MapNames {

    @Autowired
    private StreamingListener streamingListener;

    public AddSubscriptionActionHandler() {
    }

    @Override
    public AddSubscriptionResult execute(AddSubscriptionAction action) {

        for (JmxStatisticKey key : action.getJmxStatisticKeys()) {
            streamingListener.addSubscriber(action.getStreamingSessionId(), key);
        }
        return new AddSubscriptionResult();
    }

    @Override
    public Class<AddSubscriptionAction> getActionType() {
        return AddSubscriptionAction.class;
    }
}
