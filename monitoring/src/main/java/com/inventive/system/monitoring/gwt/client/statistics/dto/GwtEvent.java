package com.inventive.system.monitoring.gwt.client.statistics.dto;

import com.google.gwt.user.client.rpc.IsSerializable;

import java.math.BigDecimal;
import java.util.Date;

/**
 * User: grant
 */
public class GwtEvent implements IsSerializable {

    private String shKey;

    private String equipment;

    private String source;

    private String destination;

    private String measureCode;

    private BigDecimal measureValue;

    private String site;

    private Date eventDateTime;

    public String getShKey() {
        return shKey;
    }

    public void setShKey(String shKey) {
        this.shKey = shKey;
    }

    public String getEquipment() {
        return equipment;
    }

    public void setEquipment(String equipment) {
        this.equipment = equipment;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getMeasureCode() {
        return measureCode;
    }

    public void setMeasureCode(String measureCode) {
        this.measureCode = measureCode;
    }

    public BigDecimal getMeasureValue() {
        return measureValue;
    }

    public void setMeasureValue(BigDecimal measureValue) {
        this.measureValue = measureValue;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public Date getEventDateTime() {
        return eventDateTime;
    }

    public void setEventDateTime(Date eventDateTime) {
        this.eventDateTime = eventDateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GwtEvent event = (GwtEvent) o;

        if (destination != null ? !destination.equals(event.destination) : event.destination != null) return false;
        if (equipment != null ? !equipment.equals(event.equipment) : event.equipment != null) return false;
        if (eventDateTime != null ? !eventDateTime.equals(event.eventDateTime) : event.eventDateTime != null)
            return false;
        if (measureCode != null ? !measureCode.equals(event.measureCode) : event.measureCode != null) return false;
        if (measureValue != null ? !measureValue.equals(event.measureValue) : event.measureValue != null) return false;
        if (shKey != null ? !shKey.equals(event.shKey) : event.shKey != null) return false;
        if (site != null ? !site.equals(event.site) : event.site != null) return false;
        if (source != null ? !source.equals(event.source) : event.source != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = shKey != null ? shKey.hashCode() : 0;
        result = 31 * result + (equipment != null ? equipment.hashCode() : 0);
        result = 31 * result + (source != null ? source.hashCode() : 0);
        result = 31 * result + (destination != null ? destination.hashCode() : 0);
        result = 31 * result + (measureCode != null ? measureCode.hashCode() : 0);
        result = 31 * result + (measureValue != null ? measureValue.hashCode() : 0);
        result = 31 * result + (site != null ? site.hashCode() : 0);
        result = 31 * result + (eventDateTime != null ? eventDateTime.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Event{" +
                "shKey='" + shKey + '\'' +
                ", equipment='" + equipment + '\'' +
                ", source='" + source + '\'' +
                ", destination='" + destination + '\'' +
                ", measureCode='" + measureCode + '\'' +
                ", measureValue=" + measureValue +
                ", site='" + site + '\'' +
                ", eventDateTime=" + eventDateTime +
                '}';
    }

}
