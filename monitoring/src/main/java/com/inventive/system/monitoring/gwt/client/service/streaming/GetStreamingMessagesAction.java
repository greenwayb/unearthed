package com.inventive.system.monitoring.gwt.client.service.streaming;

import com.inventive.system.monitoring.gwt.client.service.action.Action;

/**
 * User: grant
 */
public class GetStreamingMessagesAction implements Action<GetStreamingMessagesResult> {

    private String sessionId;

    @SuppressWarnings("UnusedDeclaration")
    private GetStreamingMessagesAction() {
    }

    public GetStreamingMessagesAction(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getSessionId() {
        return sessionId;
    }
}
