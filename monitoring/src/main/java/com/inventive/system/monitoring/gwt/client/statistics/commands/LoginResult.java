package com.inventive.system.monitoring.gwt.client.statistics.commands;

import com.inventive.system.monitoring.gwt.client.User;
import com.inventive.system.monitoring.gwt.client.service.action.Result;

/**
 * User: grant
 */
public class LoginResult implements Result {

    private User user;

    private LoginResult() {
    }

    public LoginResult(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
