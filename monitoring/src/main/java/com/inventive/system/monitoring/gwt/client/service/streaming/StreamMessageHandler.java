package com.inventive.system.monitoring.gwt.client.service.streaming;

/**
 * User: grant
 */
public interface StreamMessageHandler<T extends StreamMessage> {

    void handleMessage(T message);
}
