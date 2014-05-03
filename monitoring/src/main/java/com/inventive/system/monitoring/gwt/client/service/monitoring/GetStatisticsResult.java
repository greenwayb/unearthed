package com.inventive.system.monitoring.gwt.client.service.monitoring;

import com.inventive.system.monitoring.gwt.client.service.action.Result;

/**
 * User: grant
 */
public class GetStatisticsResult implements Result {

    private String result;

    @SuppressWarnings("UnusedDeclaration")
    private GetStatisticsResult() {
    }

    public GetStatisticsResult(String result) {
        this.result = result;
    }

    public String getResult() {
        return result;
    }
}
