package com.inventive.system.monitoring.gwt.client.service.streaming;

import com.inventive.system.monitoring.gwt.client.service.action.Result;

/**
 * User: grant
 */
public class StartStreamingResult implements Result {

    private String sessionId;


    @SuppressWarnings("UnusedDeclaration")
    private StartStreamingResult() {
    }

    public StartStreamingResult(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getSessionId() {
        return sessionId;
    }
}
