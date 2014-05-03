package com.inventive.system.monitoring.gwt.server.service.streaming;

import com.inventive.system.monitoring.gwt.client.service.streaming.StartStreamingAction;
import com.inventive.system.monitoring.gwt.client.service.streaming.StartStreamingResult;
import com.inventive.system.monitoring.gwt.client.service.streaming.StopStreamingAction;
import com.inventive.system.monitoring.gwt.client.service.streaming.StopStreamingResult;
import com.inventive.system.monitoring.gwt.server.service.action.ActionHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * User: grant
 */
@Service
public class StopStreamingActionHandler implements ActionHandler<StopStreamingAction, StopStreamingResult> {

    @Autowired
    private StreamingService streamingService;

    @Override
    public StopStreamingResult execute(StopStreamingAction action) {
        streamingService.stopStreamingSession(action.getSessionId());
        return new StopStreamingResult();
    }

    @Override
    public Class<StopStreamingAction> getActionType() {
        return StopStreamingAction.class;
    }
}
