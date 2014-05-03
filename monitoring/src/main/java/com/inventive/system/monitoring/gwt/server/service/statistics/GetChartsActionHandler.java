package com.inventive.system.monitoring.gwt.server.service.statistics;

import com.google.gson.Gson;
import com.inventive.system.monitoring.gwt.client.User;
import com.inventive.system.monitoring.gwt.client.statistics.commands.GetChartsAction;
import com.inventive.system.monitoring.gwt.client.statistics.commands.GetChartsResult;
import com.inventive.system.monitoring.gwt.server.service.action.ActionHandler;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * User: grant
 */
@Service
public class GetChartsActionHandler implements ActionHandler<GetChartsAction, GetChartsResult> {

    @PersistenceContext
    private EntityManager entityManager;

    private Gson gson = new Gson();

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public GetChartsResult execute(GetChartsAction action) {

        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        User user = (User)attr.getRequest().getSession().getAttribute("user");

        if (null == user) {
            throw new IllegalStateException("User not logged in");
        }

//        TypedQuery<ChartEntity> query = entityManager.createQuery("Select c from ChartEntity c where c.user.username=:username", ChartEntity.class);
//        query.setParameter("username",  user.getUsername());
//
//        List<ChartEntity> results = query.getResultList();
//
//        ArrayList<Chart> charts = new ArrayList<Chart>();
//
//        if (results != null && results.size() >0) {
//            for (ChartEntity entity : results) {
//                String json = entity.getJson();
//                Chart chart = gson.fromJson(json, Chart.class);
//                chart.setId(entity.getId());
//                charts.add(chart);
//            }
//        }


        return new GetChartsResult(null);
    }

    @Override
    public Class<GetChartsAction> getActionType() {
        return GetChartsAction.class;
    }
}
