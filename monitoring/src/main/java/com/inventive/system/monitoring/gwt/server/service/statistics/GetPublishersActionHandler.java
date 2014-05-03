package com.inventive.system.monitoring.gwt.server.service.statistics;

import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;
import com.inventive.system.monitoring.gwt.client.statistics.commands.GetPublishersAction;
import com.inventive.system.monitoring.gwt.client.statistics.commands.GetPublishersResult;
import com.inventive.system.monitoring.gwt.server.service.action.ActionHandler;
import com.inventive.system.monitoring.server.service.publisher.MapNames;
import com.inventive.system.monitoring.server.service.publisher.StatisticEntry;
import com.inventive.system.monitoring.server.service.publisher.StatisticKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

/**
 * User: grant
 */
@Service
public class GetPublishersActionHandler implements ActionHandler<GetPublishersAction, GetPublishersResult> , MapNames{

    @Autowired
    @Qualifier("hazelcast-unearthed")
    private HazelcastInstance hazelcastInstance;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public GetPublishersResult execute(GetPublishersAction action) {

        IMap<StatisticKey, StatisticEntry> map = hazelcastInstance.getMap (STATISTICS_MAP);
        Set<StatisticKey> keys = map.keySet();

        return new GetPublishersResult(ConversionUtils.toStatisticPublisherSet(keys));
    }



    @Override
    public Class<GetPublishersAction> getActionType() {
        return GetPublishersAction.class;
    }
}
