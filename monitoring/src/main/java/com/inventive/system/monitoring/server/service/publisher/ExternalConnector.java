package com.inventive.system.monitoring.server.service.publisher;

import org.springframework.beans.factory.annotation.Required;

import java.util.Set;

/**
 * User: grant
 */
public class ExternalConnector {

    private String environment = "DEFAULT";
    private String serviceUrl;
    private Set<StatisticDescriptor> descriptors;
    private String processName;
    private String machineName;

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    public Set<StatisticDescriptor> getDescriptors() {
        return descriptors;
    }

    @Required
    public void setDescriptors(Set<StatisticDescriptor> descriptors) {
        this.descriptors = descriptors;
    }

    @Required
    public void setServiceUrl(String serviceUrl) {
        this.serviceUrl = serviceUrl;
    }

    public String getProcessName() {
        return processName;
    }

    @Required
    public void setProcessName(String processName) {
        this.processName = processName;
    }

    public String getServiceUrl() {
        return serviceUrl;
    }

    public String getMachineName() {
        return machineName;
    }

    public void setMachineName(String machineName) {
        this.machineName = machineName;
    }

    @Override
    public String toString() {
        return "ExternalConnector{" +
                "serviceUrl='" + serviceUrl + '\'' +
                ", descriptors=" + descriptors +
                ", machineName='" + machineName + '\'' +
                ", environment='" + environment + '\'' +
                ", processName='" + processName + '\'' +
                '}';
    }
}
