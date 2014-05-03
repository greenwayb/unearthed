package com.inventive.system.monitoring.gwt.client.service.streaming;

import com.inventive.system.monitoring.gwt.client.service.action.Action;

/**
 * User: grant
 */
public class StopStreamingAction implements Action<StopStreamingResult> {

    private String sessionId;

    @SuppressWarnings("UnusedDeclaration")
    private StopStreamingAction() {
    }

    public StopStreamingAction(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getSessionId() {
        return sessionId;
    }
}
