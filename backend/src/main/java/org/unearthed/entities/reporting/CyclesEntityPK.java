package org.unearthed.entities.reporting;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created with IntelliJ IDEA.
 * User: greenwayb
 * Date: 3/05/14
 * Time: 1:52 AM
 * To change this template use File | Settings | File Templates.
 */
public class CyclesEntityPK implements Serializable {
    private String shkey;

    @Id
    @Column(name = "SHKEY")
    public String getShkey() {
        return shkey;
    }

    public void setShkey(String shkey) {
        this.shkey = shkey;
    }

    private String location;

    @Id
    @Column(name = "Location")
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    private String loader;

    @Id
    @Column(name = "Loader")
    public String getLoader() {
        return loader;
    }

    public void setLoader(String loader) {
        this.loader = loader;
    }

    private String truck;

    @Id
    @Column(name = "Truck")
    public String getTruck() {
        return truck;
    }

    public void setTruck(String truck) {
        this.truck = truck;
    }

    private String destn;

    @Id
    @Column(name = "Destn")
    public String getDestn() {
        return destn;
    }

    public void setDestn(String destn) {
        this.destn = destn;
    }

    private Timestamp eventDateTime;

    @Id
    @Column(name = "EventDateTime")
    public Timestamp getEventDateTime() {
        return eventDateTime;
    }

    public void setEventDateTime(Timestamp eventDateTime) {
        this.eventDateTime = eventDateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CyclesEntityPK that = (CyclesEntityPK) o;

        if (destn != null ? !destn.equals(that.destn) : that.destn != null) return false;
        if (eventDateTime != null ? !eventDateTime.equals(that.eventDateTime) : that.eventDateTime != null)
            return false;
        if (loader != null ? !loader.equals(that.loader) : that.loader != null) return false;
        if (location != null ? !location.equals(that.location) : that.location != null) return false;
        if (shkey != null ? !shkey.equals(that.shkey) : that.shkey != null) return false;
        if (truck != null ? !truck.equals(that.truck) : that.truck != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = shkey != null ? shkey.hashCode() : 0;
        result = 31 * result + (location != null ? location.hashCode() : 0);
        result = 31 * result + (loader != null ? loader.hashCode() : 0);
        result = 31 * result + (truck != null ? truck.hashCode() : 0);
        result = 31 * result + (destn != null ? destn.hashCode() : 0);
        result = 31 * result + (eventDateTime != null ? eventDateTime.hashCode() : 0);
        return result;
    }
}
