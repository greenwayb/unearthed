package com.inventive.system.monitoring.gwt.client.statistics.dto;

import com.google.gwt.user.client.rpc.IsSerializable;

import java.io.Serializable;

/**
 * User: grant
 */
public class JmxStatisticKey implements IsSerializable, Serializable {

    private String objectName;
    private String propertyName;
    private String machineName;
    private String processName;
    private String environment;
    private String fieldName;

    public JmxStatisticKey() {
    }

    public JmxStatisticKey(String environment, String objectName, String propertyName, String machineName, String processName, String fieldName) {
        this.objectName = objectName;
        this.propertyName = propertyName;
        this.machineName = machineName;
        this.processName = processName;
        this.fieldName = fieldName;
        this.environment = environment;
    }

    public String getObjectName() {
        return objectName;
    }

    public String getMachineName() {
        return machineName;
    }

    public String getProcessName() {
        return processName;
    }

    public void setObjectName(String objectName) {
        this.objectName = objectName;
    }

    public void setMachineName(String machineName) {
        this.machineName = machineName;
    }

    public void setProcessName(String processName) {
        this.processName = processName;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        JmxStatisticKey that = (JmxStatisticKey) o;

        if (environment != null ? !environment.equals(that.environment) : that.environment != null) return false;
        if (machineName != null ? !machineName.equals(that.machineName) : that.machineName != null) return false;
        if (objectName != null ? !objectName.equals(that.objectName) : that.objectName != null) return false;
        if (processName != null ? !processName.equals(that.processName) : that.processName != null) return false;
        if (propertyName != null ? !propertyName.equals(that.propertyName) : that.propertyName != null) return false;
        if (fieldName != null ? !fieldName.equals(that.fieldName) : that.fieldName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = objectName != null ? objectName.hashCode() : 0;
        result = 31 * result + (environment != null ? environment.hashCode() : 0);
        result = 31 * result + (propertyName != null ? propertyName.hashCode() : 0);
        result = 31 * result + (machineName != null ? machineName.hashCode() : 0);
        result = 31 * result + (processName != null ? processName.hashCode() : 0);
        result = 31 * result + (fieldName != null ? fieldName.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "JmxStatisticKey{" +
                "objectName='" + objectName + '\'' +
                ", propertyName='" + propertyName + '\'' +
                ", machineName='" + machineName + '\'' +
                ", processName='" + processName + '\'' +
                ", fieldName='" + fieldName + '\'' +
                '}';
    }

    public String getDisplayName() {
        StringBuilder builder = new StringBuilder();
        builder.append(environment)
                .append("-");
        builder.append(machineName)
                .append("-");
        if (processName != null) {
            builder.append(processName)
            .append("-");
        }
        builder.append(propertyName);
        if (fieldName != null) {
            builder.append("-").append(fieldName);
        }
        return builder.toString();
    }
}
