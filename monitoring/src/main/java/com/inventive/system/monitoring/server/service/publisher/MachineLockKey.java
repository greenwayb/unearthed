package com.inventive.system.monitoring.server.service.publisher;

import java.io.Serializable;

/**
 * User: grant
 */
public class MachineLockKey implements Serializable {

    private String machineName;
    private StatisticDescriptor statisticDescriptor;

    public MachineLockKey(String machineName, StatisticDescriptor statisticDescriptor) {
        this.machineName = machineName;
        this.statisticDescriptor = statisticDescriptor;
    }

    public String getMachineName() {
        return machineName;
    }

    public StatisticDescriptor getStatisticDescriptor() {
        return statisticDescriptor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MachineLockKey that = (MachineLockKey) o;

        if (machineName != null ? !machineName.equals(that.machineName) : that.machineName != null) return false;
        if (statisticDescriptor != null ? !statisticDescriptor.equals(that.statisticDescriptor) : that.statisticDescriptor != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = machineName != null ? machineName.hashCode() : 0;
        result = 31 * result + (statisticDescriptor != null ? statisticDescriptor.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "MachineLockKey{" +
                "machineName='" + machineName + '\'' +
                ", statisticDescriptor=" + statisticDescriptor +
                '}';
    }
}
