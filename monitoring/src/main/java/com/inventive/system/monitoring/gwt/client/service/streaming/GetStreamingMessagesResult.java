package com.inventive.system.monitoring.gwt.client.service.streaming;

import com.inventive.system.monitoring.gwt.client.service.action.Result;

import java.util.List;

/**
 * User: grant
 */
public class GetStreamingMessagesResult implements Result {

    private List<StreamMessage> streamMessages;

    @SuppressWarnings("UnusedDeclaration")
    private GetStreamingMessagesResult() {
    }

    public GetStreamingMessagesResult(List<StreamMessage> streamMessages) {
        this.streamMessages = streamMessages;
    }

    public List<StreamMessage> getStreamMessages() {
        return streamMessages;
    }
}
