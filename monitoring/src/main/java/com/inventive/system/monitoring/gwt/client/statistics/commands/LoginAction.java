package com.inventive.system.monitoring.gwt.client.statistics.commands;

import com.inventive.system.monitoring.gwt.client.service.action.Action;

/**
 * User: grant
 */
public class LoginAction implements Action<LoginResult> {

    private String username;
    private String password;

    @SuppressWarnings("UnusedDeclaration")
    private LoginAction() {
    }

    public LoginAction(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
