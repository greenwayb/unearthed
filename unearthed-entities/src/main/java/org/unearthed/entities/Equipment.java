package org.unearthed.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * User: grant
 */
@Entity
@Table(name="V_Equipment")
public class Equipment implements Serializable {

    @Column(name = "Equipment_Version")
    private int equipmentVersion;

    @Id
    @Column(name = "Equipment_Id")
    private long equipmentId;

    @Column(name = "Equipment_Active")
    private String equipmentActive;

    @Column(name = "Equipment_Code")
    private String equipmentCode;

    @Column(name = "Equipment_Description")
    private String equipmentDescription;

    @Column(name = "Equipment_Model")
    private String equipmentModel;

    @Column(name = "Equipment_Model_Code")
    private String equipmentModelCode;

    @Column(name = "Equipment_Owner")
    private String equipmentOwner;

    @Column(name = "Equipment_Owner_Code")
    private String equipmentOwnerCode;

    @Column(name = "Equipment_Capacity")
    private String equipmentCapacity;

    @Column(name = "Equipment_CostMineRegion")
    private String equipmentCostMineRegion;

    @Column(name = "Equipment_CostMineRegion")
    private String equipmentLocationsEq;

    public int getEquipmentVersion() {
        return equipmentVersion;
    }

    public void setEquipmentVersion(int equipmentVersion) {
        this.equipmentVersion = equipmentVersion;
    }

    public long getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(long equipmentId) {
        this.equipmentId = equipmentId;
    }

    public String getEquipmentActive() {
        return equipmentActive;
    }

    public void setEquipmentActive(String equipmentActive) {
        this.equipmentActive = equipmentActive;
    }

    public String getEquipmentCode() {
        return equipmentCode;
    }

    public void setEquipmentCode(String equipmentCode) {
        this.equipmentCode = equipmentCode;
    }

    public String getEquipmentDescription() {
        return equipmentDescription;
    }

    public void setEquipmentDescription(String equipmentDescription) {
        this.equipmentDescription = equipmentDescription;
    }

    public String getEquipmentModel() {
        return equipmentModel;
    }

    public void setEquipmentModel(String equipmentModel) {
        this.equipmentModel = equipmentModel;
    }

    public String getEquipmentModelCode() {
        return equipmentModelCode;
    }

    public void setEquipmentModelCode(String equipmentModelCode) {
        this.equipmentModelCode = equipmentModelCode;
    }

    public String getEquipmentOwner() {
        return equipmentOwner;
    }

    public void setEquipmentOwner(String equipmentOwner) {
        this.equipmentOwner = equipmentOwner;
    }

    public String getEquipmentOwnerCode() {
        return equipmentOwnerCode;
    }

    public void setEquipmentOwnerCode(String equipmentOwnerCode) {
        this.equipmentOwnerCode = equipmentOwnerCode;
    }

    public String getEquipmentCapacity() {
        return equipmentCapacity;
    }

    public void setEquipmentCapacity(String equipmentCapacity) {
        this.equipmentCapacity = equipmentCapacity;
    }

    public String getEquipmentCostMineRegion() {
        return equipmentCostMineRegion;
    }

    public void setEquipmentCostMineRegion(String equipmentCostMineRegion) {
        this.equipmentCostMineRegion = equipmentCostMineRegion;
    }

    public String getEquipmentLocationsEq() {
        return equipmentLocationsEq;
    }

    public void setEquipmentLocationsEq(String equipmentLocationsEq) {
        this.equipmentLocationsEq = equipmentLocationsEq;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Equipment equipment = (Equipment) o;

        if (equipmentId != equipment.equipmentId) return false;
        if (equipmentVersion != equipment.equipmentVersion) return false;
        if (equipmentActive != null ? !equipmentActive.equals(equipment.equipmentActive) : equipment.equipmentActive != null)
            return false;
        if (equipmentCapacity != null ? !equipmentCapacity.equals(equipment.equipmentCapacity) : equipment.equipmentCapacity != null)
            return false;
        if (equipmentCode != null ? !equipmentCode.equals(equipment.equipmentCode) : equipment.equipmentCode != null)
            return false;
        if (equipmentCostMineRegion != null ? !equipmentCostMineRegion.equals(equipment.equipmentCostMineRegion) : equipment.equipmentCostMineRegion != null)
            return false;
        if (equipmentDescription != null ? !equipmentDescription.equals(equipment.equipmentDescription) : equipment.equipmentDescription != null)
            return false;
        if (equipmentLocationsEq != null ? !equipmentLocationsEq.equals(equipment.equipmentLocationsEq) : equipment.equipmentLocationsEq != null)
            return false;
        if (equipmentModel != null ? !equipmentModel.equals(equipment.equipmentModel) : equipment.equipmentModel != null)
            return false;
        if (equipmentModelCode != null ? !equipmentModelCode.equals(equipment.equipmentModelCode) : equipment.equipmentModelCode != null)
            return false;
        if (equipmentOwner != null ? !equipmentOwner.equals(equipment.equipmentOwner) : equipment.equipmentOwner != null)
            return false;
        if (equipmentOwnerCode != null ? !equipmentOwnerCode.equals(equipment.equipmentOwnerCode) : equipment.equipmentOwnerCode != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = equipmentVersion;
        result = 31 * result + (int) (equipmentId ^ (equipmentId >>> 32));
        result = 31 * result + (equipmentActive != null ? equipmentActive.hashCode() : 0);
        result = 31 * result + (equipmentCode != null ? equipmentCode.hashCode() : 0);
        result = 31 * result + (equipmentDescription != null ? equipmentDescription.hashCode() : 0);
        result = 31 * result + (equipmentModel != null ? equipmentModel.hashCode() : 0);
        result = 31 * result + (equipmentModelCode != null ? equipmentModelCode.hashCode() : 0);
        result = 31 * result + (equipmentOwner != null ? equipmentOwner.hashCode() : 0);
        result = 31 * result + (equipmentOwnerCode != null ? equipmentOwnerCode.hashCode() : 0);
        result = 31 * result + (equipmentCapacity != null ? equipmentCapacity.hashCode() : 0);
        result = 31 * result + (equipmentCostMineRegion != null ? equipmentCostMineRegion.hashCode() : 0);
        result = 31 * result + (equipmentLocationsEq != null ? equipmentLocationsEq.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Equipment{" +
                "equipmentVersion=" + equipmentVersion +
                ", equipmentId=" + equipmentId +
                ", equipmentActive='" + equipmentActive + '\'' +
                ", equipmentCode='" + equipmentCode + '\'' +
                ", equipmentDescription='" + equipmentDescription + '\'' +
                ", equipmentModel='" + equipmentModel + '\'' +
                ", equipmentModelCode='" + equipmentModelCode + '\'' +
                ", equipmentOwner='" + equipmentOwner + '\'' +
                ", equipmentOwnerCode='" + equipmentOwnerCode + '\'' +
                ", equipmentCapacity='" + equipmentCapacity + '\'' +
                ", equipmentCostMineRegion='" + equipmentCostMineRegion + '\'' +
                ", equipmentLocationsEq='" + equipmentLocationsEq + '\'' +
                '}';
    }
}
