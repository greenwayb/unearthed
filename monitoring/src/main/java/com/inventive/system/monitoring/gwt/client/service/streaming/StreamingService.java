package com.inventive.system.monitoring.gwt.client.service.streaming;

import com.google.inject.ImplementedBy;

/**
 * User: grant
 */
@ImplementedBy(StreamingServiceImpl.class)
public interface StreamingService {

    void start();

    void addHandler(StreamMessageHandler handler, Class klass);
    void removeHandler(StreamMessageHandler handler, Class klass);

    String getSessionId();
}
