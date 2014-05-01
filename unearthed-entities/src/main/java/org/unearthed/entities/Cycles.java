package org.unearthed.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * User: grant
 */
@Entity
@Table(name = "CYCLES")
public class Cycles implements Serializable {

    @Id
    private String shkey;

    private String location;

    private String loader;

    private String truck;

    private String destn;

    private String loaderStatus;

    private long queueTime;

    private long loadTime;

    private long moveOffTime;

    private long queueDumpTime;

    private long duration;

    private Long duationQueuing;

    private Long duationLoading;

    public String getShkey() {
        return shkey;
    }

    public void setShkey(String shkey) {
        this.shkey = shkey;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLoader() {
        return loader;
    }

    public void setLoader(String loader) {
        this.loader = loader;
    }

    public String getTruck() {
        return truck;
    }

    public void setTruck(String truck) {
        this.truck = truck;
    }

    public String getDestn() {
        return destn;
    }

    public void setDestn(String destn) {
        this.destn = destn;
    }

    public String getLoaderStatus() {
        return loaderStatus;
    }

    public void setLoaderStatus(String loaderStatus) {
        this.loaderStatus = loaderStatus;
    }

    public long getQueueTime() {
        return queueTime;
    }

    public void setQueueTime(long queueTime) {
        this.queueTime = queueTime;
    }

    public long getLoadTime() {
        return loadTime;
    }

    public void setLoadTime(long loadTime) {
        this.loadTime = loadTime;
    }

    public long getMoveOffTime() {
        return moveOffTime;
    }

    public void setMoveOffTime(long moveOffTime) {
        this.moveOffTime = moveOffTime;
    }

    public long getQueueDumpTime() {
        return queueDumpTime;
    }

    public void setQueueDumpTime(long queueDumpTime) {
        this.queueDumpTime = queueDumpTime;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public Long getDuationQueuing() {
        return duationQueuing;
    }

    public void setDuationQueuing(Long duationQueuing) {
        this.duationQueuing = duationQueuing;
    }

    public Long getDuationLoading() {
        return duationLoading;
    }

    public void setDuationLoading(Long duationLoading) {
        this.duationLoading = duationLoading;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cycles cycles = (Cycles) o;

        if (duration != cycles.duration) return false;
        if (loadTime != cycles.loadTime) return false;
        if (moveOffTime != cycles.moveOffTime) return false;
        if (queueDumpTime != cycles.queueDumpTime) return false;
        if (queueTime != cycles.queueTime) return false;
        if (destn != null ? !destn.equals(cycles.destn) : cycles.destn != null) return false;
        if (duationLoading != null ? !duationLoading.equals(cycles.duationLoading) : cycles.duationLoading != null)
            return false;
        if (duationQueuing != null ? !duationQueuing.equals(cycles.duationQueuing) : cycles.duationQueuing != null)
            return false;
        if (loader != null ? !loader.equals(cycles.loader) : cycles.loader != null) return false;
        if (loaderStatus != null ? !loaderStatus.equals(cycles.loaderStatus) : cycles.loaderStatus != null)
            return false;
        if (location != null ? !location.equals(cycles.location) : cycles.location != null) return false;
        if (shkey != null ? !shkey.equals(cycles.shkey) : cycles.shkey != null) return false;
        if (truck != null ? !truck.equals(cycles.truck) : cycles.truck != null) return false;

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
        result = 31 * result + (int) (queueTime ^ (queueTime >>> 32));
        result = 31 * result + (int) (loadTime ^ (loadTime >>> 32));
        result = 31 * result + (int) (moveOffTime ^ (moveOffTime >>> 32));
        result = 31 * result + (int) (queueDumpTime ^ (queueDumpTime >>> 32));
        result = 31 * result + (int) (duration ^ (duration >>> 32));
        result = 31 * result + (duationQueuing != null ? duationQueuing.hashCode() : 0);
        result = 31 * result + (duationLoading != null ? duationLoading.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Cycles{" +
                "shkey='" + shkey + '\'' +
                ", location='" + location + '\'' +
                ", loader='" + loader + '\'' +
                ", truck='" + truck + '\'' +
                ", destn='" + destn + '\'' +
                ", loaderStatus='" + loaderStatus + '\'' +
                ", queueTime=" + queueTime +
                ", loadTime=" + loadTime +
                ", moveOffTime=" + moveOffTime +
                ", queueDumpTime=" + queueDumpTime +
                ", duration=" + duration +
                ", duationQueuing=" + duationQueuing +
                ", duationLoading=" + duationLoading +
                '}';
    }
}
