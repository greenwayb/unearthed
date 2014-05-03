package com.inventive.system.monitoring.gwt.server.service.streaming;

import com.inventive.system.monitoring.gwt.client.service.streaming.StartStreamingAction;
import com.inventive.system.monitoring.gwt.client.service.streaming.StartStreamingResult;
import com.inventive.system.monitoring.gwt.server.service.action.ActionHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * User: grant
 */
@Service
public class StartStreamingActionHandler implements ActionHandler<StartStreamingAction, StartStreamingResult> {

    @Autowired
    private StreamingService streamingService;

    @Override
    public StartStreamingResult execute(StartStreamingAction action) {
        String sessionId = streamingService.startStreamSession(action.getInterval());
        return new StartStreamingResult(sessionId);
    }

    @Override
    public Class<StartStreamingAction> getActionType() {
        return StartStreamingAction.class;
    }
}
