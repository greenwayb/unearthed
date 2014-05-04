package org.unearthed.entities;

/**
 * User: grant
 */
public class UnregisterQuery {

    private String clientId;
    private String listenerId;

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getListenerId() {
        return listenerId;
    }

    public void setListenerId(String listenerId) {
        this.listenerId = listenerId;
    }
}
