package org.unearthed.webservices.rest;

import org.glassfish.jersey.media.sse.SseFeature;
import org.glassfish.jersey.server.ResourceConfig;

import javax.ws.rs.ApplicationPath;

/**
 * User: grant
 */
@ApplicationPath("services")
public class SSEApplication extends ResourceConfig {

    public SSEApplication() {
        super(Unearthed.SseResource.class, SseFeature.class);
    }
}