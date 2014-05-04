package org.unearthed.entities;

import java.math.BigDecimal;

/**
 * User: grant
 */
public class Cycle extends Event {

    private BigDecimal durationLoading;
    private BigDecimal durationQueueing;
    private BigDecimal durationTravelEmpty;
    private BigDecimal durationTravelLoaded;

    public BigDecimal getDurationLoading() {
        return durationLoading;
    }

    public void setDurationLoading(BigDecimal durationLoading) {
        this.durationLoading = durationLoading;
    }

    public BigDecimal getDurationQueueing() {
        return durationQueueing;
    }

    public void setDurationQueueing(BigDecimal durationQueueing) {
        this.durationQueueing = durationQueueing;
    }

    public BigDecimal getDurationTravelEmpty() {
        return durationTravelEmpty;
    }

    public void setDurationTravelEmpty(BigDecimal durationTravelEmpty) {
        this.durationTravelEmpty = durationTravelEmpty;
    }

    public BigDecimal getDurationTravelLoaded() {
        return durationTravelLoaded;
    }

    public void setDurationTravelLoaded(BigDecimal durationTravelLoaded) {
        this.durationTravelLoaded = durationTravelLoaded;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Cycle cycle = (Cycle) o;

        if (durationLoading != null ? !durationLoading.equals(cycle.durationLoading) : cycle.durationLoading != null)
            return false;
        if (durationQueueing != null ? !durationQueueing.equals(cycle.durationQueueing) : cycle.durationQueueing != null)
            return false;
        if (durationTravelEmpty != null ? !durationTravelEmpty.equals(cycle.durationTravelEmpty) : cycle.durationTravelEmpty != null)
            return false;
        if (durationTravelLoaded != null ? !durationTravelLoaded.equals(cycle.durationTravelLoaded) : cycle.durationTravelLoaded != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (durationLoading != null ? durationLoading.hashCode() : 0);
        result = 31 * result + (durationQueueing != null ? durationQueueing.hashCode() : 0);
        result = 31 * result + (durationTravelEmpty != null ? durationTravelEmpty.hashCode() : 0);
        result = 31 * result + (durationTravelLoaded != null ? durationTravelLoaded.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Cycle{" +
                "durationLoading=" + durationLoading +
                ", durationQueueing=" + durationQueueing +
                ", durationTravelEmpty=" + durationTravelEmpty +
                ", durationTravelLoaded=" + durationTravelLoaded +
                '}';
    }
}
