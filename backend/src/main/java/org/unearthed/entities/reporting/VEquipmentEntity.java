package org.unearthed.entities.reporting;

import javax.persistence.Basic;
import javax.persistence.Entity;
import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: greenwayb
 * Date: 3/05/14
 * Time: 1:54 AM
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.Table(name = "V_EQUIPMENT", schema = "dbo", catalog = "HCK_PITRAMReporting")
@Entity
public class VEquipmentEntity {
    private String equipmentCode2;

    @javax.persistence.Column(name = "EquipmentCode")
    @Basic
    public String getEquipmentCode2() {
        return equipmentCode2;
    }

    public void setEquipmentCode2(String equipmentCode2) {
        this.equipmentCode2 = equipmentCode2;
    }

    private Integer equipmentVersion;

    @javax.persistence.Column(name = "Equipment_Version")
    @Basic
    public Integer getEquipmentVersion() {
        return equipmentVersion;
    }

    public void setEquipmentVersion(Integer equipmentVersion) {
        this.equipmentVersion = equipmentVersion;
    }

    private Long equipmentId;

    @javax.persistence.Column(name = "Equipment_Id")
    @Basic
    public Long getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(Long equipmentId) {
        this.equipmentId = equipmentId;
    }

    private Integer equipmentActive;

    @javax.persistence.Column(name = "Equipment_Active")
    @Basic
    public Integer getEquipmentActive() {
        return equipmentActive;
    }

    public void setEquipmentActive(Integer equipmentActive) {
        this.equipmentActive = equipmentActive;
    }

    private String equipmentCode;

    @javax.persistence.Column(name = "Equipment_Code")
    @Basic
    public String getEquipmentCode() {
        return equipmentCode;
    }

    public void setEquipmentCode(String equipmentCode) {
        this.equipmentCode = equipmentCode;
    }

    private String equipmentDescription;

    @javax.persistence.Column(name = "Equipment_Description")
    @Basic
    public String getEquipmentDescription() {
        return equipmentDescription;
    }

    public void setEquipmentDescription(String equipmentDescription) {
        this.equipmentDescription = equipmentDescription;
    }

    private String equipmentAbbreviation;

    @javax.persistence.Column(name = "Equipment_Abbreviation")
    @Basic
    public String getEquipmentAbbreviation() {
        return equipmentAbbreviation;
    }

    public void setEquipmentAbbreviation(String equipmentAbbreviation) {
        this.equipmentAbbreviation = equipmentAbbreviation;
    }

    private String equipmentDescriptionCode;

    @javax.persistence.Column(name = "Equipment_Description_Code")
    @Basic
    public String getEquipmentDescriptionCode() {
        return equipmentDescriptionCode;
    }

    public void setEquipmentDescriptionCode(String equipmentDescriptionCode) {
        this.equipmentDescriptionCode = equipmentDescriptionCode;
    }

    private String equipmentAllEquipment;

    @javax.persistence.Column(name = "Equipment_All_Equipment")
    @Basic
    public String getEquipmentAllEquipment() {
        return equipmentAllEquipment;
    }

    public void setEquipmentAllEquipment(String equipmentAllEquipment) {
        this.equipmentAllEquipment = equipmentAllEquipment;
    }

    private Serializable equipmentLocationsEq;

    @javax.persistence.Column(name = "Equipment_LocationsEq")
    @Basic
    public Serializable getEquipmentLocationsEq() {
        return equipmentLocationsEq;
    }

    public void setEquipmentLocationsEq(Serializable equipmentLocationsEq) {
        this.equipmentLocationsEq = equipmentLocationsEq;
    }

    private String equipmentModel;

    @javax.persistence.Column(name = "Equipment_Model")
    @Basic
    public String getEquipmentModel() {
        return equipmentModel;
    }

    public void setEquipmentModel(String equipmentModel) {
        this.equipmentModel = equipmentModel;
    }

    private String equipmentModelCode;

    @javax.persistence.Column(name = "Equipment_Model_Code")
    @Basic
    public String getEquipmentModelCode() {
        return equipmentModelCode;
    }

    public void setEquipmentModelCode(String equipmentModelCode) {
        this.equipmentModelCode = equipmentModelCode;
    }

    private String equipmentOwner;

    @javax.persistence.Column(name = "Equipment_Owner")
    @Basic
    public String getEquipmentOwner() {
        return equipmentOwner;
    }

    public void setEquipmentOwner(String equipmentOwner) {
        this.equipmentOwner = equipmentOwner;
    }

    private String equipmentOwnerCode;

    @javax.persistence.Column(name = "Equipment_Owner_Code")
    @Basic
    public String getEquipmentOwnerCode() {
        return equipmentOwnerCode;
    }

    public void setEquipmentOwnerCode(String equipmentOwnerCode) {
        this.equipmentOwnerCode = equipmentOwnerCode;
    }

    private Serializable equipmentCapacity;

    @javax.persistence.Column(name = "Equipment_Capacity")
    @Basic
    public Serializable getEquipmentCapacity() {
        return equipmentCapacity;
    }

    public void setEquipmentCapacity(Serializable equipmentCapacity) {
        this.equipmentCapacity = equipmentCapacity;
    }

    private String equipmentCostMineRegion;

    @javax.persistence.Column(name = "Equipment_CostMineRegion")
    @Basic
    public String getEquipmentCostMineRegion() {
        return equipmentCostMineRegion;
    }

    public void setEquipmentCostMineRegion(String equipmentCostMineRegion) {
        this.equipmentCostMineRegion = equipmentCostMineRegion;
    }

    public void setEquipmentCostMineRegion(String equipmentCostMineRegion) {
        this.equipmentCostMineRegion = equipmentCostMineRegion;
    }    private String equipmentCostMineRegionCode;

    @javax.persistence.Column(name = "Equipment_CostMineRegion_Code")
    @Basic
    public String getEquipmentCostMineRegionCode() {
        return equipmentCostMineRegionCode;
    }

    public void setEquipmentCostMineRegionCode(String equipmentCostMineRegionCode) {
        this.equipmentCostMineRegionCode = equipmentCostMineRegionCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VEquipmentEntity that = (VEquipmentEntity) o;

        if (equipmentAbbreviation != null ? !equipmentAbbreviation.equals(that.equipmentAbbreviation) : that.equipmentAbbreviation != null)
            return false;
        if (equipmentActive != null ? !equipmentActive.equals(that.equipmentActive) : that.equipmentActive != null)
            return false;
        if (equipmentAllEquipment != null ? !equipmentAllEquipment.equals(that.equipmentAllEquipment) : that.equipmentAllEquipment != null)
            return false;
        if (equipmentCapacity != null ? !equipmentCapacity.equals(that.equipmentCapacity) : that.equipmentCapacity != null)
            return false;
        if (equipmentCode != null ? !equipmentCode.equals(that.equipmentCode) : that.equipmentCode != null)
            return false;
        if (equipmentCode2 != null ? !equipmentCode2.equals(that.equipmentCode2) : that.equipmentCode2 != null)
            return false;
        if (equipmentCostMineRegion != null ? !equipmentCostMineRegion.equals(that.equipmentCostMineRegion) : that.equipmentCostMineRegion != null)
            return false;
        if (equipmentCostMineRegionCode != null ? !equipmentCostMineRegionCode.equals(that.equipmentCostMineRegionCode) : that.equipmentCostMineRegionCode != null)
            return false;
        if (equipmentDescription != null ? !equipmentDescription.equals(that.equipmentDescription) : that.equipmentDescription != null)
            return false;
        if (equipmentDescriptionCode != null ? !equipmentDescriptionCode.equals(that.equipmentDescriptionCode) : that.equipmentDescriptionCode != null)
            return false;
        if (equipmentId != null ? !equipmentId.equals(that.equipmentId) : that.equipmentId != null) return false;
        if (equipmentLocationsEq != null ? !equipmentLocationsEq.equals(that.equipmentLocationsEq) : that.equipmentLocationsEq != null)
            return false;
        if (equipmentModel != null ? !equipmentModel.equals(that.equipmentModel) : that.equipmentModel != null)
            return false;
        if (equipmentModelCode != null ? !equipmentModelCode.equals(that.equipmentModelCode) : that.equipmentModelCode != null)
            return false;
        if (equipmentOwner != null ? !equipmentOwner.equals(that.equipmentOwner) : that.equipmentOwner != null)
            return false;
        if (equipmentOwnerCode != null ? !equipmentOwnerCode.equals(that.equipmentOwnerCode) : that.equipmentOwnerCode != null)
            return false;
        if (equipmentVersion != null ? !equipmentVersion.equals(that.equipmentVersion) : that.equipmentVersion != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = equipmentCode2 != null ? equipmentCode2.hashCode() : 0;
        result = 31 * result + (equipmentVersion != null ? equipmentVersion.hashCode() : 0);
        result = 31 * result + (equipmentId != null ? equipmentId.hashCode() : 0);
        result = 31 * result + (equipmentActive != null ? equipmentActive.hashCode() : 0);
        result = 31 * result + (equipmentCode != null ? equipmentCode.hashCode() : 0);
        result = 31 * result + (equipmentDescription != null ? equipmentDescription.hashCode() : 0);
        result = 31 * result + (equipmentAbbreviation != null ? equipmentAbbreviation.hashCode() : 0);
        result = 31 * result + (equipmentDescriptionCode != null ? equipmentDescriptionCode.hashCode() : 0);
        result = 31 * result + (equipmentAllEquipment != null ? equipmentAllEquipment.hashCode() : 0);
        result = 31 * result + (equipmentLocationsEq != null ? equipmentLocationsEq.hashCode() : 0);
        result = 31 * result + (equipmentModel != null ? equipmentModel.hashCode() : 0);
        result = 31 * result + (equipmentModelCode != null ? equipmentModelCode.hashCode() : 0);
        result = 31 * result + (equipmentOwner != null ? equipmentOwner.hashCode() : 0);
        result = 31 * result + (equipmentOwnerCode != null ? equipmentOwnerCode.hashCode() : 0);
        result = 31 * result + (equipmentCapacity != null ? equipmentCapacity.hashCode() : 0);
        result = 31 * result + (equipmentCostMineRegion != null ? equipmentCostMineRegion.hashCode() : 0);
        result = 31 * result + (equipmentCostMineRegionCode != null ? equipmentCostMineRegionCode.hashCode() : 0);
        return result;
    }
}
