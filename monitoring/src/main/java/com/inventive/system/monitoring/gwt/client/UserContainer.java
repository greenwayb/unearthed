package com.inventive.system.monitoring.gwt.client;

/**
 * User: grant
 */
public class UserContainer {

    private static User user;

    public static User getUser() {
        return user;
    }

    public static void setUser(User user) {
        UserContainer.user = user;
    }
}
