package org.unearthed.entities;

/**
 * User: grant
 */
public class RegisterQuery {

    private String query;
    private String clientId;

    public RegisterQuery() {
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }
}
