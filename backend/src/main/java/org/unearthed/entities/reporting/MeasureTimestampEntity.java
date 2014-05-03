package org.unearthed.entities.reporting;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: greenwayb
 * Date: 3/05/14
 * Time: 1:52 AM
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.Table(name = "MEASURETIMESTAMP", schema = "dbo", catalog = "HCK_PITRAMReporting")
@Entity
public class MeasureTimestampEntity {
    @Id
    @javax.persistence.Column(name = "TSKey")
    private Long tsKey;

    @javax.persistence.Column(name = "EventTime")
    private String eventTime;

    @javax.persistence.Column(name = "MeasureValue")
    private String measureValue;

    @javax.persistence.Column(name = "CycleKey")
    private String cycleKey;

    @javax.persistence.Column(name = "MeasureTransactionKey")
    private String measureTransactionKey;

    @javax.persistence.Column(name = "EventDateTime")
    @Temporal(TemporalType.DATE)
    private Date eventDateTime;


    public Long getTsKey() {
        return tsKey;
    }

    public void setTsKey(Long key) {
        this.tsKey = key;
    }

    public String getEventTime() {
        return eventTime;
    }

    public void setEventTime(String eventTime) {
        this.eventTime = eventTime;
    }

    public String getMeasureValue() {
        return measureValue;
    }

    public void setMeasureValue(String measureValue) {
        this.measureValue = measureValue;
    }

    public String getCycleKey() {
        return cycleKey;
    }

    public void setCycleKey(String cycleKey) {
        this.cycleKey = cycleKey;
    }

    public String getMeasureTransactionKey() {
        return measureTransactionKey;
    }

    public void setMeasureTransactionKey(String measureTransactionKey) {
        this.measureTransactionKey = measureTransactionKey;
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

        MeasureTimestampEntity that = (MeasureTimestampEntity) o;

        if (cycleKey != null ? !cycleKey.equals(that.cycleKey) : that.cycleKey != null) return false;
        if (eventDateTime != null ? !eventDateTime.equals(that.eventDateTime) : that.eventDateTime != null)
            return false;
        if (eventTime != null ? !eventTime.equals(that.eventTime) : that.eventTime != null) return false;
        if (measureTransactionKey != null ? !measureTransactionKey.equals(that.measureTransactionKey) : that.measureTransactionKey != null)
            return false;
        if (measureValue != null ? !measureValue.equals(that.measureValue) : that.measureValue != null) return false;
        if (tsKey != null ? !tsKey.equals(that.tsKey) : that.tsKey != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = tsKey != null ? tsKey.hashCode() : 0;
        result = 31 * result + (eventTime != null ? eventTime.hashCode() : 0);
        result = 31 * result + (measureValue != null ? measureValue.hashCode() : 0);
        result = 31 * result + (cycleKey != null ? cycleKey.hashCode() : 0);
        result = 31 * result + (measureTransactionKey != null ? measureTransactionKey.hashCode() : 0);
        result = 31 * result + (eventDateTime != null ? eventDateTime.hashCode() : 0);
        return result;
    }
}
