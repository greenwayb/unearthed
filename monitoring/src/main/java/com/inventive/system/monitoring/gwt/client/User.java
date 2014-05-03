package com.inventive.system.monitoring.gwt.client;

import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * User: grant
 */
public class User implements IsSerializable {

    private String username;

    public User() {
    }

    public User(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
}
