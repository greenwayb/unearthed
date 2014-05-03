package org.unearthed.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * User: grant
 */
public class Event implements Serializable {

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
}
