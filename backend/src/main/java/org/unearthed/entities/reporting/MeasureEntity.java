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
@javax.persistence.Table(name = "MEASURE", schema = "dbo", catalog = "HCK_PITRAMReporting")
@Entity
public class MeasureEntity {
    private Long key;
    private String measCode;
    private Double measVal;

    @javax.persistence.Column(name = "Key")
    @Basic
    public Long getKey() {
        return key;
    }

    public void setKey(Long key) {
        this.key = key;
    }

    @javax.persistence.Column(name = "MeasCode")
    @Basic
    public String getMeasCode() {
        return measCode;
    }

    public void setMeasCode(String measCode) {
        this.measCode = measCode;
    }

    @javax.persistence.Column(name = "Meas_Val")
    @Basic
    public Double getMeasVal() {
        return measVal;
    }

    public void setMeasVal(Double measVal) {
        this.measVal = measVal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MeasureEntity that = (MeasureEntity) o;

        if (key != null ? !key.equals(that.key) : that.key != null) return false;
        if (measCode != null ? !measCode.equals(that.measCode) : that.measCode != null) return false;
        if (measVal != null ? !measVal.equals(that.measVal) : that.measVal != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = key != null ? key.hashCode() : 0;
        result = 31 * result + (measCode != null ? measCode.hashCode() : 0);
        result = 31 * result + (measVal != null ? measVal.hashCode() : 0);
        return result;
    }
}
