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
}
