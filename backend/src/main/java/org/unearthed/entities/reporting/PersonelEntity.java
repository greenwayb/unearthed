package org.unearthed.entities.reporting;

import javax.persistence.Basic;
import javax.persistence.Entity;

/**
 * Created with IntelliJ IDEA.
 * User: greenwayb
 * Date: 3/05/14
 * Time: 1:52 AM
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.Table(name = "PERSONEL", schema = "dbo", catalog = "HCK_PITRAMReporting")
@Entity
public class PersonelEntity {
    private String shkey;
    private String equipment;
    private String operator;
    private String role;
    private Double duration;

    @javax.persistence.Column(name = "shkey")
    @Basic
    public String getShkey() {
        return shkey;
    }

    public void setShkey(String shkey) {
        this.shkey = shkey;
    }

    @javax.persistence.Column(name = "equipment")
    @Basic
    public String getEquipment() {
        return equipment;
    }

    public void setEquipment(String equipment) {
        this.equipment = equipment;
    }

    @javax.persistence.Column(name = "operator")
    @Basic
    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    @javax.persistence.Column(name = "role")
    @Basic
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @javax.persistence.Column(name = "Duration")
    @Basic
    public Double getDuration() {
        return duration;
    }

    public void setDuration(Double duration) {
        this.duration = duration;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PersonelEntity that = (PersonelEntity) o;

        if (duration != null ? !duration.equals(that.duration) : that.duration != null) return false;
        if (equipment != null ? !equipment.equals(that.equipment) : that.equipment != null) return false;
        if (operator != null ? !operator.equals(that.operator) : that.operator != null) return false;
        if (role != null ? !role.equals(that.role) : that.role != null) return false;
        if (shkey != null ? !shkey.equals(that.shkey) : that.shkey != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = shkey != null ? shkey.hashCode() : 0;
        result = 31 * result + (equipment != null ? equipment.hashCode() : 0);
        result = 31 * result + (operator != null ? operator.hashCode() : 0);
        result = 31 * result + (role != null ? role.hashCode() : 0);
        result = 31 * result + (duration != null ? duration.hashCode() : 0);
        return result;
    }
}
