package com.inventive.system.monitoring.gwt.server.service.streaming;

import com.inventive.system.monitoring.gwt.client.service.streaming.StreamMessage;

import java.util.ArrayList;

/**
 * User: grant
 */
public interface StreamingService {

    void sendToAll(StreamMessage message);
    String startStreamSession(int interval);
    void stopStreamingSession(String sessionId);
    void sendToSession(String sessionId, StreamMessage message);
    ArrayList<StreamMessage> getMessages(String sessionId);
}
