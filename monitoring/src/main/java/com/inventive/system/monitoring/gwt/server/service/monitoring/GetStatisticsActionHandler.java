package com.inventive.system.monitoring.gwt.server.service.monitoring;

import com.inventive.system.monitoring.gwt.client.service.monitoring.GetStatisticsAction;
import com.inventive.system.monitoring.gwt.client.service.monitoring.GetStatisticsResult;
import com.inventive.system.monitoring.gwt.server.service.action.ActionHandler;
import org.springframework.stereotype.Service;
/**
 * User: grant
 */
@Service
public class GetStatisticsActionHandler implements ActionHandler<GetStatisticsAction, GetStatisticsResult> {

    public GetStatisticsActionHandler() {
    }

    @Override
    public GetStatisticsResult execute(GetStatisticsAction action) {
        return new GetStatisticsResult("Value");
    }

    @Override
    public Class<GetStatisticsAction> getActionType() {
        return GetStatisticsAction.class;
    }
}
