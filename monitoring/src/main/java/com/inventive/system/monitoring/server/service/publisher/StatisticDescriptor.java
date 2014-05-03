package com.inventive.system.monitoring.server.service.publisher;

import java.io.Serializable;

/**
 * User: grant
 */
public class StatisticDescriptor implements Serializable {

    private String objectName;
    private String propertyName;
    private Long interval;
    private StatisticConverter converter;
    private String fieldName;

    public StatisticDescriptor() {
    }

    public StatisticDescriptor(String objectName, String propertyName, Long interval, String fieldName) {
        this.objectName = objectName;
        this.propertyName = propertyName;
        this.interval = interval;
        this.fieldName = fieldName;
    }

    public StatisticDescriptor(String objectName, String propertyName, Long interval, String fieldName, StatisticConverter converter) {
        this.objectName = objectName;
        this.propertyName = propertyName;
        this.interval = interval;
        this.converter = converter;
        this.fieldName = fieldName;
    }

    public String getObjectName() {
        return objectName;
    }

    public void setObjectName(String objectName) {
        this.objectName = objectName;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public Long getInterval() {
        return interval;
    }

    public void setInterval(Long interval) {
        this.interval = interval;
    }

    public StatisticConverter getConverter() {
        return converter;
    }

    public void setConverter(StatisticConverter converter) {
        this.converter = converter;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StatisticDescriptor that = (StatisticDescriptor) o;

        if (converter != null ? !converter.equals(that.converter) : that.converter != null) return false;
        if (interval != null ? !interval.equals(that.interval) : that.interval != null) return false;
        if (objectName != null ? !objectName.equals(that.objectName) : that.objectName != null) return false;
        if (propertyName != null ? !propertyName.equals(that.propertyName) : that.propertyName != null) return false;
        if (fieldName != null ? !fieldName.equals(that.fieldName) : that.fieldName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = objectName != null ? objectName.hashCode() : 0;
        result = 31 * result + (propertyName != null ? propertyName.hashCode() : 0);
        result = 31 * result + (interval != null ? interval.hashCode() : 0);
        result = 31 * result + (converter != null ? converter.hashCode() : 0);
        result = 31 * result + (fieldName != null ? fieldName.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "StatisticDescriptor{" +
                "objectName='" + objectName + '\'' +
                ", propertyName='" + propertyName + '\'' +
                ", interval=" + interval +
                ", title=" + fieldName +
                ", converter=" + converter +
                '}';
    }
}
