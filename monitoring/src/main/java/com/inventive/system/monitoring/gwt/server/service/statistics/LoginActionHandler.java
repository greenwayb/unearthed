package com.inventive.system.monitoring.gwt.server.service.statistics;

import com.inventive.system.monitoring.gwt.client.statistics.commands.LoginAction;
import com.inventive.system.monitoring.gwt.client.statistics.commands.LoginResult;
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
public class LoginActionHandler implements ActionHandler<LoginAction, LoginResult> {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public LoginResult execute(LoginAction action) {

//        UserEntity userEntity = entityManager.find(UserEntity.class, action.getUsername());
//
//        if (userEntity == null) {
//            userEntity = new UserEntity(action.getUsername(), action.getPassword());
//            userEntity = entityManager.merge(userEntity);
//            entityManager.flush();
//        }
//
//        User user = null;
//        if (userEntity.getPassword().equals(action.getPassword())) {
//            user = new User(userEntity.getUsername());
//            ServletRequestAttributes attr = (ServletRequestAttributes)RequestContextHolder.currentRequestAttributes();
//            attr.getRequest().getSession().setAttribute("user", user);
//        }
//
//
//
        return new LoginResult(null);
    }

    @Override
    public Class<LoginAction> getActionType() {
        return LoginAction.class;
    }
}
