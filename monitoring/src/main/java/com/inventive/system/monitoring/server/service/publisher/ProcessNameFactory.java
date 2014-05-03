package com.inventive.system.monitoring.server.service.publisher;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Required;

/**
 * User: grant
 */
public class ProcessNameFactory implements FactoryBean<String> {

    private String processName;

    @Override
    public String getObject() throws Exception {
        return processName;
    }

    @Override
    public Class<?> getObjectType() {
        return String.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }

    @Required
    public void setProcessName(String processName) {
        this.processName = processName;
    }
}
