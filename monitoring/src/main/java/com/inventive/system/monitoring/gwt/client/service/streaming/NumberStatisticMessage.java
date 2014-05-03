package com.inventive.system.monitoring.gwt.client.service.streaming;

import com.google.gwt.user.client.rpc.IsSerializable;
import com.inventive.system.monitoring.gwt.client.statistics.dto.JmxStatisticKey;

import java.util.ArrayList;
import java.util.Date;

/**
 * User: grant
 */
public class NumberStatisticMessage implements StreamMessage {

    private JmxStatisticKey identifier;

    private ArrayList<TimeAndValue> values;

    @SuppressWarnings("UnusedDeclaration")
    private NumberStatisticMessage() {
    }

    public ArrayList<TimeAndValue> getValues() {
        return values;
    }

    public NumberStatisticMessage(JmxStatisticKey identifier, ArrayList<TimeAndValue> values) {
        this.identifier = identifier;
        this.values = values;
    }

    public JmxStatisticKey getIdentifier() {
        return identifier;
    }


    public static class TimeAndValue implements IsSerializable, Comparable<TimeAndValue> {
        private Date time;
        private Number value;

        public TimeAndValue() {
        }

        public TimeAndValue(Date time, Number value) {
            this.time = time;
            this.value = value;
        }

        public Date getTime() {
            return time;
        }

        public Number getValue() {
            return value;
        }

        @Override
        public int compareTo(TimeAndValue timeAndValue) {
            return time.compareTo(timeAndValue.getTime());
        }
    }
}
