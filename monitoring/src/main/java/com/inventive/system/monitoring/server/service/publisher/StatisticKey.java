package com.inventive.system.monitoring.server.service.publisher;

import java.io.Serializable;
import java.util.Date;

/**
 * User: grant
 */
public class StatisticKey implements Serializable {

    private String environment;
    private String machineName;
    private String processName;
    private Date date;
    private String objectName;
    private String propertyName;
    private String fieldName;

    public StatisticKey(String environment, String machineName, String processName, Date date, String objectName, String propertyName, String fieldName ) {
        this.environment = environment;
        this.machineName = machineName;
        this.processName = processName;
        this.objectName = objectName;
        this.propertyName = propertyName;
        this.fieldName = fieldName;
        this.date = date;
    }

    public String getMachineName() {
        return machineName;
    }

    public String getProcessName() {
        return processName;
    }

    public Date getDate() {
        return date;
    }

    public String getObjectName() {
        return objectName;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public String getFieldName() {
        return fieldName;
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

        StatisticKey that = (StatisticKey) o;

        if (date != null ? !date.equals(that.date) : that.date != null) return false;
        if (fieldName != null ? !fieldName.equals(that.fieldName) : that.fieldName != null) return false;
        if (environment != null ? !environment.equals(that.environment) : that.environment != null) return false;
        if (machineName != null ? !machineName.equals(that.machineName) : that.machineName != null) return false;
        if (objectName != null ? !objectName.equals(that.objectName) : that.objectName != null) return false;
        if (processName != null ? !processName.equals(that.processName) : that.processName != null) return false;
        if (propertyName != null ? !propertyName.equals(that.propertyName) : that.propertyName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = machineName != null ? machineName.hashCode() : 0;
        result = 31 * result + (environment != null ? environment.hashCode() : 0);
        result = 31 * result + (processName != null ? processName.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (objectName != null ? objectName.hashCode() : 0);
        result = 31 * result + (propertyName != null ? propertyName.hashCode() : 0);
        result = 31 * result + (fieldName != null ? fieldName.hashCode() : 0);
        return result;
    }
}
