package com.inventive.system.monitoring.gwt.server.service.streaming;

import com.inventive.system.monitoring.gwt.client.service.streaming.GetStreamingMessagesAction;
import com.inventive.system.monitoring.gwt.client.service.streaming.GetStreamingMessagesResult;
import com.inventive.system.monitoring.gwt.server.service.action.ActionHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * User: grant
 */
@Service
public class GetStreamingMessagesActionHandler implements ActionHandler<GetStreamingMessagesAction, GetStreamingMessagesResult> {

    @Autowired
    private StreamingService streamingService;

    @Override
    public GetStreamingMessagesResult execute(GetStreamingMessagesAction action) {
        return new GetStreamingMessagesResult(streamingService.getMessages(action.getSessionId()));
    }

    @Override
    public Class<GetStreamingMessagesAction> getActionType() {
        return GetStreamingMessagesAction.class;
    }
}
