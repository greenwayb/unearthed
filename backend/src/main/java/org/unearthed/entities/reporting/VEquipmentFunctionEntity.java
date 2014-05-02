package org.unearthed.entities.reporting;

import javax.persistence.Basic;
import javax.persistence.Entity;
import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: greenwayb
 * Date: 3/05/14
 * Time: 1:56 AM
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.Table(name = "V_EQUIPMENT_FUNCTION", schema = "dbo", catalog = "HCK_PITRAMReporting")
@Entity
public class VEquipmentFunctionEntity {
    private String equipmentFunctionCode2;
    private Integer equipmentFunctionVersion;
    private Long equipmentFunctionId;
    private Integer equipmentFunctionActive;
    private String equipmentFunctionCode;
    private String equipmentFunctionDescription;
    private String equipmentFunctionAbbreviation;
    private String equipmentFunctionDescriptionCode;
    private String equipmentFunctionAllEquipmentFunction;
    private Serializable equipmentFunctionPrimaryStates;
    private String equipmentFunctionDisplayMeasure;
    private String equipmentFunctionDisplayMeasureCode;

    @javax.persistence.Column(name = "Equipment_FunctionCode")
    @Basic
    public String getEquipmentFunctionCode2() {
        return equipmentFunctionCode2;
    }

    public void setEquipmentFunctionCode2(String equipmentFunctionCode2) {
        this.equipmentFunctionCode2 = equipmentFunctionCode2;
    }

    @javax.persistence.Column(name = "Equipment_Function_Version")
    @Basic
    public Integer getEquipmentFunctionVersion() {
        return equipmentFunctionVersion;
    }

    public void setEquipmentFunctionVersion(Integer equipmentFunctionVersion) {
        this.equipmentFunctionVersion = equipmentFunctionVersion;
    }

    @javax.persistence.Column(name = "Equipment_Function_Id")
    @Basic
    public Long getEquipmentFunctionId() {
        return equipmentFunctionId;
    }

    public void setEquipmentFunctionId(Long equipmentFunctionId) {
        this.equipmentFunctionId = equipmentFunctionId;
    }

    @javax.persistence.Column(name = "Equipment_Function_Active")
    @Basic
    public Integer getEquipmentFunctionActive() {
        return equipmentFunctionActive;
    }

    public void setEquipmentFunctionActive(Integer equipmentFunctionActive) {
        this.equipmentFunctionActive = equipmentFunctionActive;
    }

    @javax.persistence.Column(name = "Equipment_Function_Code")
    @Basic
    public String getEquipmentFunctionCode() {
        return equipmentFunctionCode;
    }

    public void setEquipmentFunctionCode(String equipmentFunctionCode) {
        this.equipmentFunctionCode = equipmentFunctionCode;
    }

    @javax.persistence.Column(name = "Equipment_Function_Description")
    @Basic
    public String getEquipmentFunctionDescription() {
        return equipmentFunctionDescription;
    }

    public void setEquipmentFunctionDescription(String equipmentFunctionDescription) {
        this.equipmentFunctionDescription = equipmentFunctionDescription;
    }

    @javax.persistence.Column(name = "Equipment_Function_Abbreviation")
    @Basic
    public String getEquipmentFunctionAbbreviation() {
        return equipmentFunctionAbbreviation;
    }

    public void setEquipmentFunctionAbbreviation(String equipmentFunctionAbbreviation) {
        this.equipmentFunctionAbbreviation = equipmentFunctionAbbreviation;
    }

    @javax.persistence.Column(name = "Equipment_Function_Description_Code")
    @Basic
    public String getEquipmentFunctionDescriptionCode() {
        return equipmentFunctionDescriptionCode;
    }

    public void setEquipmentFunctionDescriptionCode(String equipmentFunctionDescriptionCode) {
        this.equipmentFunctionDescriptionCode = equipmentFunctionDescriptionCode;
    }

    @javax.persistence.Column(name = "Equipment_Function_All_Equipment_Function")
    @Basic
    public String getEquipmentFunctionAllEquipmentFunction() {
        return equipmentFunctionAllEquipmentFunction;
    }

    public void setEquipmentFunctionAllEquipmentFunction(String equipmentFunctionAllEquipmentFunction) {
        this.equipmentFunctionAllEquipmentFunction = equipmentFunctionAllEquipmentFunction;
    }

    @javax.persistence.Column(name = "Equipment_Function_PrimaryStates")
    @Basic
    public Serializable getEquipmentFunctionPrimaryStates() {
        return equipmentFunctionPrimaryStates;
    }

    public void setEquipmentFunctionPrimaryStates(Serializable equipmentFunctionPrimaryStates) {
        this.equipmentFunctionPrimaryStates = equipmentFunctionPrimaryStates;
    }

    @javax.persistence.Column(name = "Equipment_Function_DisplayMeasure")
    @Basic
    public String getEquipmentFunctionDisplayMeasure() {
        return equipmentFunctionDisplayMeasure;
    }

    public void setEquipmentFunctionDisplayMeasure(String equipmentFunctionDisplayMeasure) {
        this.equipmentFunctionDisplayMeasure = equipmentFunctionDisplayMeasure;
    }

    @javax.persistence.Column(name = "Equipment_Function_DisplayMeasure_Code")
    @Basic
    public String getEquipmentFunctionDisplayMeasureCode() {
        return equipmentFunctionDisplayMeasureCode;
    }

    public void setEquipmentFunctionDisplayMeasureCode(String equipmentFunctionDisplayMeasureCode) {
        this.equipmentFunctionDisplayMeasureCode = equipmentFunctionDisplayMeasureCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VEquipmentFunctionEntity that = (VEquipmentFunctionEntity) o;

        if (equipmentFunctionAbbreviation != null ? !equipmentFunctionAbbreviation.equals(that.equipmentFunctionAbbreviation) : that.equipmentFunctionAbbreviation != null)
            return false;
        if (equipmentFunctionActive != null ? !equipmentFunctionActive.equals(that.equipmentFunctionActive) : that.equipmentFunctionActive != null)
            return false;
        if (equipmentFunctionAllEquipmentFunction != null ? !equipmentFunctionAllEquipmentFunction.equals(that.equipmentFunctionAllEquipmentFunction) : that.equipmentFunctionAllEquipmentFunction != null)
            return false;
        if (equipmentFunctionCode != null ? !equipmentFunctionCode.equals(that.equipmentFunctionCode) : that.equipmentFunctionCode != null)
            return false;
        if (equipmentFunctionCode2 != null ? !equipmentFunctionCode2.equals(that.equipmentFunctionCode2) : that.equipmentFunctionCode2 != null)
            return false;
        if (equipmentFunctionDescription != null ? !equipmentFunctionDescription.equals(that.equipmentFunctionDescription) : that.equipmentFunctionDescription != null)
            return false;
        if (equipmentFunctionDescriptionCode != null ? !equipmentFunctionDescriptionCode.equals(that.equipmentFunctionDescriptionCode) : that.equipmentFunctionDescriptionCode != null)
            return false;
        if (equipmentFunctionDisplayMeasure != null ? !equipmentFunctionDisplayMeasure.equals(that.equipmentFunctionDisplayMeasure) : that.equipmentFunctionDisplayMeasure != null)
            return false;
        if (equipmentFunctionDisplayMeasureCode != null ? !equipmentFunctionDisplayMeasureCode.equals(that.equipmentFunctionDisplayMeasureCode) : that.equipmentFunctionDisplayMeasureCode != null)
            return false;
        if (equipmentFunctionId != null ? !equipmentFunctionId.equals(that.equipmentFunctionId) : that.equipmentFunctionId != null)
            return false;
        if (equipmentFunctionPrimaryStates != null ? !equipmentFunctionPrimaryStates.equals(that.equipmentFunctionPrimaryStates) : that.equipmentFunctionPrimaryStates != null)
            return false;
        if (equipmentFunctionVersion != null ? !equipmentFunctionVersion.equals(that.equipmentFunctionVersion) : that.equipmentFunctionVersion != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = equipmentFunctionCode2 != null ? equipmentFunctionCode2.hashCode() : 0;
        result = 31 * result + (equipmentFunctionVersion != null ? equipmentFunctionVersion.hashCode() : 0);
        result = 31 * result + (equipmentFunctionId != null ? equipmentFunctionId.hashCode() : 0);
        result = 31 * result + (equipmentFunctionActive != null ? equipmentFunctionActive.hashCode() : 0);
        result = 31 * result + (equipmentFunctionCode != null ? equipmentFunctionCode.hashCode() : 0);
        result = 31 * result + (equipmentFunctionDescription != null ? equipmentFunctionDescription.hashCode() : 0);
        result = 31 * result + (equipmentFunctionAbbreviation != null ? equipmentFunctionAbbreviation.hashCode() : 0);
        result = 31 * result + (equipmentFunctionDescriptionCode != null ? equipmentFunctionDescriptionCode.hashCode() : 0);
        result = 31 * result + (equipmentFunctionAllEquipmentFunction != null ? equipmentFunctionAllEquipmentFunction.hashCode() : 0);
        result = 31 * result + (equipmentFunctionPrimaryStates != null ? equipmentFunctionPrimaryStates.hashCode() : 0);
        result = 31 * result + (equipmentFunctionDisplayMeasure != null ? equipmentFunctionDisplayMeasure.hashCode() : 0);
        result = 31 * result + (equipmentFunctionDisplayMeasureCode != null ? equipmentFunctionDisplayMeasureCode.hashCode() : 0);
        return result;
    }
}
