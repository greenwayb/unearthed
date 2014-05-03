package org.unearthed.entities.reporting;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created with IntelliJ IDEA.
 * User: greenwayb
 * Date: 3/05/14
 * Time: 1:52 AM
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.Table(name = "ALLOCTN", schema = "dbo", catalog = "HCK_PITRAMReporting")
@Entity
public class AlloctnEntity {
    private String shkey;
    private String equipmnt;
    private String operator;
    private String location;
    private String status;
    private String destn;
    private String material;
    private String role;
    @Id
    private Long key;

    @javax.persistence.Column(name = "SHKEY")
    @Basic
    public String getShkey() {
        return shkey;
    }

    public void setShkey(String shkey) {
        this.shkey = shkey;
    }

    @javax.persistence.Column(name = "Equipmnt")
    @Basic
    public String getEquipmnt() {
        return equipmnt;
    }

    public void setEquipmnt(String equipmnt) {
        this.equipmnt = equipmnt;
    }

    @javax.persistence.Column(name = "Operator")
    @Basic
    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    @javax.persistence.Column(name = "Location")
    @Basic
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @javax.persistence.Column(name = "Status")
    @Basic
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @javax.persistence.Column(name = "Destn")
    @Basic
    public String getDestn() {
        return destn;
    }

    public void setDestn(String destn) {
        this.destn = destn;
    }

    @javax.persistence.Column(name = "Material")
    @Basic
    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    @javax.persistence.Column(name = "Role")
    @Basic
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @javax.persistence.Column(name = "Key")
    @Basic
    public Long getKey() {
        return key;
    }

    public void setKey(Long key) {
        this.key = key;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AlloctnEntity that = (AlloctnEntity) o;

        if (destn != null ? !destn.equals(that.destn) : that.destn != null) return false;
        if (equipmnt != null ? !equipmnt.equals(that.equipmnt) : that.equipmnt != null) return false;
        if (key != null ? !key.equals(that.key) : that.key != null) return false;
        if (location != null ? !location.equals(that.location) : that.location != null) return false;
        if (material != null ? !material.equals(that.material) : that.material != null) return false;
        if (operator != null ? !operator.equals(that.operator) : that.operator != null) return false;
        if (role != null ? !role.equals(that.role) : that.role != null) return false;
        if (shkey != null ? !shkey.equals(that.shkey) : that.shkey != null) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = shkey != null ? shkey.hashCode() : 0;
        result = 31 * result + (equipmnt != null ? equipmnt.hashCode() : 0);
        result = 31 * result + (operator != null ? operator.hashCode() : 0);
        result = 31 * result + (location != null ? location.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (destn != null ? destn.hashCode() : 0);
        result = 31 * result + (material != null ? material.hashCode() : 0);
        result = 31 * result + (role != null ? role.hashCode() : 0);
        result = 31 * result + (key != null ? key.hashCode() : 0);
        return result;
    }
}
