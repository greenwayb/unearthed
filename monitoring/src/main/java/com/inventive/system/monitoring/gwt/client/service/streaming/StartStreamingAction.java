package com.inventive.system.monitoring.gwt.client.service.streaming;

import com.inventive.system.monitoring.gwt.client.service.action.Action;

/**
 * User: grant
 */
public class StartStreamingAction implements Action<StartStreamingResult> {

    private int interval;

    @SuppressWarnings("UnusedDeclaration")
    private StartStreamingAction() {
    }

    public StartStreamingAction(int interval) {
        this.interval = interval;
    }

    public int getInterval() {
        return interval;
    }
}
