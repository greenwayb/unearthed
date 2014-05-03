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
@javax.persistence.Table(name = "ALLOCTNTIMESTAMP", schema = "dbo", catalog = "HCK_PITRAMReporting")
@Entity
public class AlloctntimestampEntity {
    private Long tsKey;
    private String shKey;
    private String equipment;
    private String location;
    private String destn;
    private String status;
    private String operator;
    private String primaryEquipment;
    private Long summaryKey;
    private String material;
    private String assignedDestn;
    private Timestamp eventDateTime;
    private Integer eventSource;
    private String meascode;

    @javax.persistence.Column(name = "TSKey")
    @Id
    public Long getTsKey() {
        return tsKey;
    }

    public void setTsKey(Long tsKey) {
        this.tsKey = tsKey;
    }

    @javax.persistence.Column(name = "ShKey")
    @Basic
    public String getShKey() {
        return shKey;
    }

    public void setShKey(String shKey) {
        this.shKey = shKey;
    }

    @javax.persistence.Column(name = "Equipment")
    @Basic
    public String getEquipment() {
        return equipment;
    }

    public void setEquipment(String equipment) {
        this.equipment = equipment;
    }

    @javax.persistence.Column(name = "Location")
    @Basic
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @javax.persistence.Column(name = "Destn")
    @Basic
    public String getDestn() {
        return destn;
    }

    public void setDestn(String destn) {
        this.destn = destn;
    }

    @javax.persistence.Column(name = "Status")
    @Basic
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @javax.persistence.Column(name = "Operator")
    @Basic
    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    @javax.persistence.Column(name = "PrimaryEquipment")
    @Basic
    public String getPrimaryEquipment() {
        return primaryEquipment;
    }

    public void setPrimaryEquipment(String primaryEquipment) {
        this.primaryEquipment = primaryEquipment;
    }

    @javax.persistence.Column(name = "SummaryKey")
    @Basic
    public Long getSummaryKey() {
        return summaryKey;
    }

    public void setSummaryKey(Long summaryKey) {
        this.summaryKey = summaryKey;
    }

    @javax.persistence.Column(name = "Material")
    @Basic
    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    @javax.persistence.Column(name = "AssignedDestn")
    @Basic
    public String getAssignedDestn() {
        return assignedDestn;
    }

    public void setAssignedDestn(String assignedDestn) {
        this.assignedDestn = assignedDestn;
    }

    @javax.persistence.Column(name = "EventDateTime")
    @Basic
    public Timestamp getEventDateTime() {
        return eventDateTime;
    }

    public void setEventDateTime(Timestamp eventDateTime) {
        this.eventDateTime = eventDateTime;
    }

    @javax.persistence.Column(name = "EventSource")
    @Basic
    public Integer getEventSource() {
        return eventSource;
    }

    public void setEventSource(Integer eventSource) {
        this.eventSource = eventSource;
    }

    @javax.persistence.Column(name = "MEASCODE")
    @Basic
    public String getMeascode() {
        return meascode;
    }

    public void setMeascode(String meascode) {
        this.meascode = meascode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AlloctntimestampEntity that = (AlloctntimestampEntity) o;

        if (assignedDestn != null ? !assignedDestn.equals(that.assignedDestn) : that.assignedDestn != null)
            return false;
        if (destn != null ? !destn.equals(that.destn) : that.destn != null) return false;
        if (equipment != null ? !equipment.equals(that.equipment) : that.equipment != null) return false;
        if (eventDateTime != null ? !eventDateTime.equals(that.eventDateTime) : that.eventDateTime != null)
            return false;
        if (eventSource != null ? !eventSource.equals(that.eventSource) : that.eventSource != null) return false;
        if (location != null ? !location.equals(that.location) : that.location != null) return false;
        if (material != null ? !material.equals(that.material) : that.material != null) return false;
        if (operator != null ? !operator.equals(that.operator) : that.operator != null) return false;
        if (primaryEquipment != null ? !primaryEquipment.equals(that.primaryEquipment) : that.primaryEquipment != null)
            return false;
        if (shKey != null ? !shKey.equals(that.shKey) : that.shKey != null) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;
        if (summaryKey != null ? !summaryKey.equals(that.summaryKey) : that.summaryKey != null) return false;
        if (tsKey != null ? !tsKey.equals(that.tsKey) : that.tsKey != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = tsKey != null ? tsKey.hashCode() : 0;
        result = 31 * result + (shKey != null ? shKey.hashCode() : 0);
        result = 31 * result + (equipment != null ? equipment.hashCode() : 0);
        result = 31 * result + (location != null ? location.hashCode() : 0);
        result = 31 * result + (destn != null ? destn.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (operator != null ? operator.hashCode() : 0);
        result = 31 * result + (primaryEquipment != null ? primaryEquipment.hashCode() : 0);
        result = 31 * result + (summaryKey != null ? summaryKey.hashCode() : 0);
        result = 31 * result + (material != null ? material.hashCode() : 0);
        result = 31 * result + (assignedDestn != null ? assignedDestn.hashCode() : 0);
        result = 31 * result + (eventDateTime != null ? eventDateTime.hashCode() : 0);
        result = 31 * result + (eventSource != null ? eventSource.hashCode() : 0);
        return result;
    }
}
