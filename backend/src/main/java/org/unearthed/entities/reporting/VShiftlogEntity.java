package org.unearthed.entities.reporting;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created with IntelliJ IDEA.
 * User: greenwayb
 * Date: 3/05/14
 * Time: 1:53 AM
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.Table(name = "V_SHIFTLOG", schema = "dbo", catalog = "HCK_PITRAMReporting")
@Entity
public class VShiftlogEntity {
    private String periodShift;
    private String periodYear;
    private String periodMonth;
    private String periodDay;
    private String shiftCode;
    private String lastShiftShift;
    @Id
    private String shiftKey;
    private String periodMonthCode;
    private String periodYearCode;
    private String periodDayCode;
    private String periodShiftCode;
    private String periodAll;
    private String periodAllCode;
    private String periodWeek;
    private String periodWeekCode;
    private String periodProductionPeriod;
    private String periodProductionPeriodCode;
    private String periodProductionPeriodSortCode;

    @javax.persistence.Column(name = "Period_Shift")
    @Basic
    public String getPeriodShift() {
        return periodShift;
    }

    public void setPeriodShift(String periodShift) {
        this.periodShift = periodShift;
    }

    @javax.persistence.Column(name = "Period_Year")
    @Basic
    public String getPeriodYear() {
        return periodYear;
    }

    public void setPeriodYear(String periodYear) {
        this.periodYear = periodYear;
    }

    @javax.persistence.Column(name = "Period_Month")
    @Basic
    public String getPeriodMonth() {
        return periodMonth;
    }

    public void setPeriodMonth(String periodMonth) {
        this.periodMonth = periodMonth;
    }

    @javax.persistence.Column(name = "Period_Day")
    @Basic
    public String getPeriodDay() {
        return periodDay;
    }

    public void setPeriodDay(String periodDay) {
        this.periodDay = periodDay;
    }

    @javax.persistence.Column(name = "ShiftCode")
    @Basic
    public String getShiftCode() {
        return shiftCode;
    }

    public void setShiftCode(String shiftCode) {
        this.shiftCode = shiftCode;
    }

    @javax.persistence.Column(name = "LastShift_Shift")
    @Basic
    public String getLastShiftShift() {
        return lastShiftShift;
    }

    public void setLastShiftShift(String lastShiftShift) {
        this.lastShiftShift = lastShiftShift;
    }

    @javax.persistence.Column(name = "Shift_Key")
    @Basic
    public String getShiftKey() {
        return shiftKey;
    }

    public void setShiftKey(String shiftKey) {
        this.shiftKey = shiftKey;
    }

    @javax.persistence.Column(name = "Period_Month_Code")
    @Basic
    public String getPeriodMonthCode() {
        return periodMonthCode;
    }

    public void setPeriodMonthCode(String periodMonthCode) {
        this.periodMonthCode = periodMonthCode;
    }

    @javax.persistence.Column(name = "Period_Year_Code")
    @Basic
    public String getPeriodYearCode() {
        return periodYearCode;
    }

    public void setPeriodYearCode(String periodYearCode) {
        this.periodYearCode = periodYearCode;
    }

    @javax.persistence.Column(name = "Period_Day_Code")
    @Basic
    public String getPeriodDayCode() {
        return periodDayCode;
    }

    public void setPeriodDayCode(String periodDayCode) {
        this.periodDayCode = periodDayCode;
    }

    @javax.persistence.Column(name = "Period_Shift_Code")
    @Basic
    public String getPeriodShiftCode() {
        return periodShiftCode;
    }

    public void setPeriodShiftCode(String periodShiftCode) {
        this.periodShiftCode = periodShiftCode;
    }

    @javax.persistence.Column(name = "Period_All")
    @Basic
    public String getPeriodAll() {
        return periodAll;
    }

    public void setPeriodAll(String periodAll) {
        this.periodAll = periodAll;
    }

    @javax.persistence.Column(name = "Period_All_Code")
    @Basic
    public String getPeriodAllCode() {
        return periodAllCode;
    }

    public void setPeriodAllCode(String periodAllCode) {
        this.periodAllCode = periodAllCode;
    }

    @javax.persistence.Column(name = "Period_Week")
    @Basic
    public String getPeriodWeek() {
        return periodWeek;
    }

    public void setPeriodWeek(String periodWeek) {
        this.periodWeek = periodWeek;
    }

    @javax.persistence.Column(name = "Period_Week_Code")
    @Basic
    public String getPeriodWeekCode() {
        return periodWeekCode;
    }

    public void setPeriodWeekCode(String periodWeekCode) {
        this.periodWeekCode = periodWeekCode;
    }

    @javax.persistence.Column(name = "Period_ProductionPeriod")
    @Basic
    public String getPeriodProductionPeriod() {
        return periodProductionPeriod;
    }

    public void setPeriodProductionPeriod(String periodProductionPeriod) {
        this.periodProductionPeriod = periodProductionPeriod;
    }

    @javax.persistence.Column(name = "Period_ProductionPeriod_Code")
    @Basic
    public String getPeriodProductionPeriodCode() {
        return periodProductionPeriodCode;
    }

    public void setPeriodProductionPeriodCode(String periodProductionPeriodCode) {
        this.periodProductionPeriodCode = periodProductionPeriodCode;
    }

    @javax.persistence.Column(name = "Period_ProductionPeriod_SortCode")
    @Basic
    public String getPeriodProductionPeriodSortCode() {
        return periodProductionPeriodSortCode;
    }

    public void setPeriodProductionPeriodSortCode(String periodProductionPeriodSortCode) {
        this.periodProductionPeriodSortCode = periodProductionPeriodSortCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VShiftlogEntity that = (VShiftlogEntity) o;

        if (lastShiftShift != null ? !lastShiftShift.equals(that.lastShiftShift) : that.lastShiftShift != null)
            return false;
        if (periodAll != null ? !periodAll.equals(that.periodAll) : that.periodAll != null) return false;
        if (periodAllCode != null ? !periodAllCode.equals(that.periodAllCode) : that.periodAllCode != null)
            return false;
        if (periodDay != null ? !periodDay.equals(that.periodDay) : that.periodDay != null) return false;
        if (periodDayCode != null ? !periodDayCode.equals(that.periodDayCode) : that.periodDayCode != null)
            return false;
        if (periodMonth != null ? !periodMonth.equals(that.periodMonth) : that.periodMonth != null) return false;
        if (periodMonthCode != null ? !periodMonthCode.equals(that.periodMonthCode) : that.periodMonthCode != null)
            return false;
        if (periodProductionPeriod != null ? !periodProductionPeriod.equals(that.periodProductionPeriod) : that.periodProductionPeriod != null)
            return false;
        if (periodProductionPeriodCode != null ? !periodProductionPeriodCode.equals(that.periodProductionPeriodCode) : that.periodProductionPeriodCode != null)
            return false;
        if (periodProductionPeriodSortCode != null ? !periodProductionPeriodSortCode.equals(that.periodProductionPeriodSortCode) : that.periodProductionPeriodSortCode != null)
            return false;
        if (periodShift != null ? !periodShift.equals(that.periodShift) : that.periodShift != null) return false;
        if (periodShiftCode != null ? !periodShiftCode.equals(that.periodShiftCode) : that.periodShiftCode != null)
            return false;
        if (periodWeek != null ? !periodWeek.equals(that.periodWeek) : that.periodWeek != null) return false;
        if (periodWeekCode != null ? !periodWeekCode.equals(that.periodWeekCode) : that.periodWeekCode != null)
            return false;
        if (periodYear != null ? !periodYear.equals(that.periodYear) : that.periodYear != null) return false;
        if (periodYearCode != null ? !periodYearCode.equals(that.periodYearCode) : that.periodYearCode != null)
            return false;
        if (shiftCode != null ? !shiftCode.equals(that.shiftCode) : that.shiftCode != null) return false;
        if (shiftKey != null ? !shiftKey.equals(that.shiftKey) : that.shiftKey != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = periodShift != null ? periodShift.hashCode() : 0;
        result = 31 * result + (periodYear != null ? periodYear.hashCode() : 0);
        result = 31 * result + (periodMonth != null ? periodMonth.hashCode() : 0);
        result = 31 * result + (periodDay != null ? periodDay.hashCode() : 0);
        result = 31 * result + (shiftCode != null ? shiftCode.hashCode() : 0);
        result = 31 * result + (lastShiftShift != null ? lastShiftShift.hashCode() : 0);
        result = 31 * result + (shiftKey != null ? shiftKey.hashCode() : 0);
        result = 31 * result + (periodMonthCode != null ? periodMonthCode.hashCode() : 0);
        result = 31 * result + (periodYearCode != null ? periodYearCode.hashCode() : 0);
        result = 31 * result + (periodDayCode != null ? periodDayCode.hashCode() : 0);
        result = 31 * result + (periodShiftCode != null ? periodShiftCode.hashCode() : 0);
        result = 31 * result + (periodAll != null ? periodAll.hashCode() : 0);
        result = 31 * result + (periodAllCode != null ? periodAllCode.hashCode() : 0);
        result = 31 * result + (periodWeek != null ? periodWeek.hashCode() : 0);
        result = 31 * result + (periodWeekCode != null ? periodWeekCode.hashCode() : 0);
        result = 31 * result + (periodProductionPeriod != null ? periodProductionPeriod.hashCode() : 0);
        result = 31 * result + (periodProductionPeriodCode != null ? periodProductionPeriodCode.hashCode() : 0);
        result = 31 * result + (periodProductionPeriodSortCode != null ? periodProductionPeriodSortCode.hashCode() : 0);
        return result;
    }
}
