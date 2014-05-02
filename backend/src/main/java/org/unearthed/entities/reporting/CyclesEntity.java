package org.unearthed.entities.reporting;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;

/**
 * Created with IntelliJ IDEA.
 * User: greenwayb
 * Date: 3/05/14
 * Time: 1:52 AM
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.IdClass(org.unearthed.entities.reporting.CyclesEntityPK.class)
@javax.persistence.Table(name = "CYCLES", schema = "dbo", catalog = "HCK_PITRAMReporting")
@Entity
public class CyclesEntity {
    private String shkey;
    private String location;
    private String loader;
    private String truck;
    private String destn;
    private String loaderStatus;
    private String queueTime;
    private String loadTime;
    private String moveOffTime;
    private String queueDumpTime;
    private Double duration;
    private Double durationQueueing;
    private Double durationLoading;
    private Double durationTravelLoaded;
    private Double durationQueueAtDump;
    private Double durationTravelEmpty;
    private Double quantity;
    private Timestamp eventDateTime;
    private Long tsKey;
    private Long cycleKey;
    private Integer eventSource;

    @javax.persistence.Column(name = "SHKEY")
    @Id
    public String getShkey() {
        return shkey;
    }

    public void setShkey(String shkey) {
        this.shkey = shkey;
    }

    @javax.persistence.Column(name = "Location")
    @Id
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @javax.persistence.Column(name = "Loader")
    @Id
    public String getLoader() {
        return loader;
    }

    public void setLoader(String loader) {
        this.loader = loader;
    }

    @javax.persistence.Column(name = "Truck")
    @Id
    public String getTruck() {
        return truck;
    }

    public void setTruck(String truck) {
        this.truck = truck;
    }

    @javax.persistence.Column(name = "Destn")
    @Id
    public String getDestn() {
        return destn;
    }

    public void setDestn(String destn) {
        this.destn = destn;
    }

    @javax.persistence.Column(name = "LoaderStatus")
    @Basic
    public String getLoaderStatus() {
        return loaderStatus;
    }

    public void setLoaderStatus(String loaderStatus) {
        this.loaderStatus = loaderStatus;
    }

    @javax.persistence.Column(name = "QueueTime")
    @Basic
    public String getQueueTime() {
        return queueTime;
    }

    public void setQueueTime(String queueTime) {
        this.queueTime = queueTime;
    }

    @javax.persistence.Column(name = "LoadTime")
    @Basic
    public String getLoadTime() {
        return loadTime;
    }

    public void setLoadTime(String loadTime) {
        this.loadTime = loadTime;
    }

    @javax.persistence.Column(name = "MoveOffTime")
    @Basic
    public String getMoveOffTime() {
        return moveOffTime;
    }

    public void setMoveOffTime(String moveOffTime) {
        this.moveOffTime = moveOffTime;
    }

    @javax.persistence.Column(name = "QueueDumpTime")
    @Basic
    public String getQueueDumpTime() {
        return queueDumpTime;
    }

    public void setQueueDumpTime(String queueDumpTime) {
        this.queueDumpTime = queueDumpTime;
    }

    @javax.persistence.Column(name = "Duration")
    @Basic
    public Double getDuration() {
        return duration;
    }

    public void setDuration(Double duration) {
        this.duration = duration;
    }

    @javax.persistence.Column(name = "DurationQueueing")
    @Basic
    public Double getDurationQueueing() {
        return durationQueueing;
    }

    public void setDurationQueueing(Double durationQueueing) {
        this.durationQueueing = durationQueueing;
    }

    @javax.persistence.Column(name = "DurationLoading")
    @Basic
    public Double getDurationLoading() {
        return durationLoading;
    }

    public void setDurationLoading(Double durationLoading) {
        this.durationLoading = durationLoading;
    }

    @javax.persistence.Column(name = "DurationTravelLoaded")
    @Basic
    public Double getDurationTravelLoaded() {
        return durationTravelLoaded;
    }

    public void setDurationTravelLoaded(Double durationTravelLoaded) {
        this.durationTravelLoaded = durationTravelLoaded;
    }

    @javax.persistence.Column(name = "DurationQueueAtDump")
    @Basic
    public Double getDurationQueueAtDump() {
        return durationQueueAtDump;
    }

    public void setDurationQueueAtDump(Double durationQueueAtDump) {
        this.durationQueueAtDump = durationQueueAtDump;
    }

    @javax.persistence.Column(name = "DurationTravelEmpty")
    @Basic
    public Double getDurationTravelEmpty() {
        return durationTravelEmpty;
    }

    public void setDurationTravelEmpty(Double durationTravelEmpty) {
        this.durationTravelEmpty = durationTravelEmpty;
    }

    @javax.persistence.Column(name = "Quantity")
    @Basic
    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    @javax.persistence.Column(name = "EventDateTime")
    @Id
    public Timestamp getEventDateTime() {
        return eventDateTime;
    }

    public void setEventDateTime(Timestamp eventDateTime) {
        this.eventDateTime = eventDateTime;
    }

    @javax.persistence.Column(name = "TSKey")
    @Basic
    public Long getTsKey() {
        return tsKey;
    }

    public void setTsKey(Long tsKey) {
        this.tsKey = tsKey;
    }

    @javax.persistence.Column(name = "CycleKey")
    @Basic
    public Long getCycleKey() {
        return cycleKey;
    }

    public void setCycleKey(Long cycleKey) {
        this.cycleKey = cycleKey;
    }

    @javax.persistence.Column(name = "EventSource")
    @Basic
    public Integer getEventSource() {
        return eventSource;
    }

    public void setEventSource(Integer eventSource) {
        this.eventSource = eventSource;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CyclesEntity that = (CyclesEntity) o;

        if (cycleKey != null ? !cycleKey.equals(that.cycleKey) : that.cycleKey != null) return false;
        if (destn != null ? !destn.equals(that.destn) : that.destn != null) return false;
        if (duration != null ? !duration.equals(that.duration) : that.duration != null) return false;
        if (durationLoading != null ? !durationLoading.equals(that.durationLoading) : that.durationLoading != null)
            return false;
        if (durationQueueAtDump != null ? !durationQueueAtDump.equals(that.durationQueueAtDump) : that.durationQueueAtDump != null)
            return false;
        if (durationQueueing != null ? !durationQueueing.equals(that.durationQueueing) : that.durationQueueing != null)
            return false;
        if (durationTravelEmpty != null ? !durationTravelEmpty.equals(that.durationTravelEmpty) : that.durationTravelEmpty != null)
            return false;
        if (durationTravelLoaded != null ? !durationTravelLoaded.equals(that.durationTravelLoaded) : that.durationTravelLoaded != null)
            return false;
        if (eventDateTime != null ? !eventDateTime.equals(that.eventDateTime) : that.eventDateTime != null)
            return false;
        if (eventSource != null ? !eventSource.equals(that.eventSource) : that.eventSource != null) return false;
        if (loadTime != null ? !loadTime.equals(that.loadTime) : that.loadTime != null) return false;
        if (loader != null ? !loader.equals(that.loader) : that.loader != null) return false;
        if (loaderStatus != null ? !loaderStatus.equals(that.loaderStatus) : that.loaderStatus != null) return false;
        if (location != null ? !location.equals(that.location) : that.location != null) return false;
        if (moveOffTime != null ? !moveOffTime.equals(that.moveOffTime) : that.moveOffTime != null) return false;
        if (quantity != null ? !quantity.equals(that.quantity) : that.quantity != null) return false;
        if (queueDumpTime != null ? !queueDumpTime.equals(that.queueDumpTime) : that.queueDumpTime != null)
            return false;
        if (queueTime != null ? !queueTime.equals(that.queueTime) : that.queueTime != null) return false;
        if (shkey != null ? !shkey.equals(that.shkey) : that.shkey != null) return false;
        if (truck != null ? !truck.equals(that.truck) : that.truck != null) return false;
        if (tsKey != null ? !tsKey.equals(that.tsKey) : that.tsKey != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = shkey != null ? shkey.hashCode() : 0;
        result = 31 * result + (location != null ? location.hashCode() : 0);
        result = 31 * result + (loader != null ? loader.hashCode() : 0);
        result = 31 * result + (truck != null ? truck.hashCode() : 0);
        result = 31 * result + (destn != null ? destn.hashCode() : 0);
        result = 31 * result + (loaderStatus != null ? loaderStatus.hashCode() : 0);
        result = 31 * result + (queueTime != null ? queueTime.hashCode() : 0);
        result = 31 * result + (loadTime != null ? loadTime.hashCode() : 0);
        result = 31 * result + (moveOffTime != null ? moveOffTime.hashCode() : 0);
        result = 31 * result + (queueDumpTime != null ? queueDumpTime.hashCode() : 0);
        result = 31 * result + (duration != null ? duration.hashCode() : 0);
        result = 31 * result + (durationQueueing != null ? durationQueueing.hashCode() : 0);
        result = 31 * result + (durationLoading != null ? durationLoading.hashCode() : 0);
        result = 31 * result + (durationTravelLoaded != null ? durationTravelLoaded.hashCode() : 0);
        result = 31 * result + (durationQueueAtDump != null ? durationQueueAtDump.hashCode() : 0);
        result = 31 * result + (durationTravelEmpty != null ? durationTravelEmpty.hashCode() : 0);
        result = 31 * result + (quantity != null ? quantity.hashCode() : 0);
        result = 31 * result + (eventDateTime != null ? eventDateTime.hashCode() : 0);
        result = 31 * result + (tsKey != null ? tsKey.hashCode() : 0);
        result = 31 * result + (cycleKey != null ? cycleKey.hashCode() : 0);
        result = 31 * result + (eventSource != null ? eventSource.hashCode() : 0);
        return result;
    }
}
