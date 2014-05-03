package com.inventive.system.monitoring.gwt.server.service.statistics;

import com.google.gson.Gson;
import com.inventive.system.monitoring.gwt.client.statistics.commands.RemoveChartAction;
import com.inventive.system.monitoring.gwt.client.statistics.commands.RemoveChartResult;
import com.inventive.system.monitoring.gwt.server.service.action.ActionHandler;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * User: grant
 */
@Service
public class RemoveChartActionHandler implements ActionHandler<RemoveChartAction, RemoveChartResult> {

    @PersistenceContext
    private EntityManager entityManager;

    private Gson gson = new Gson();


    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public RemoveChartResult execute(RemoveChartAction action) {
//        ChartEntity entity = entityManager.find(ChartEntity.class, action.getChart().getId());
//        if (null != entity) {
//            entityManager.remove(entity);
//        }
        return new RemoveChartResult();
    }

//    private ChartEntity toChartEntity(Chart in) {
//        ChartEntity out = new ChartEntity();
//        out.setId(in.getId());
//        out.setJson(gson.toJson(in));
//        return out;
//    }

    @Override
    public Class<RemoveChartAction> getActionType() {
        return RemoveChartAction.class;
    }
}
