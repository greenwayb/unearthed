package org.unearthed.webservices.rest;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * User: grant
 */
@Service
public class ClientRegister {

    private Map<String, List<String>> clients = new ConcurrentHashMap<String, List<String>>();


    public void broadcast(String json) {
        for (List<String> events : clients.values()) {
            events.add(json);
        }
    }

    public void addClientMessage(String clientId, String json) {
        clients.get(clientId).add(json);
    }

    public List<String> getClientMessages(String clientId) {
        return clients.get(clientId);
    }
}
