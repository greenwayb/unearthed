package com.inventive.system.monitoring.gwt.server.service.statistics;

import com.inventive.system.monitoring.gwt.client.statistics.dto.GwtStatisticDescriptor;
import com.inventive.system.monitoring.gwt.client.statistics.dto.JmxStatisticKey;
import com.inventive.system.monitoring.server.service.publisher.StatisticDescriptor;
import com.inventive.system.monitoring.server.service.publisher.StatisticEntry;
import com.inventive.system.monitoring.server.service.publisher.StatisticKey;

import java.util.*;

/**
 * User: grant
 */
public class ConversionUtils {

    public static JmxStatisticKey toJmxStatisticKey(StatisticKey in) {
        return new JmxStatisticKey(in.getEnvironment(), in.getObjectName(), in.getPropertyName(), in.getMachineName(), in.getProcessName(), in.getFieldName());
    }

    public static List<JmxStatisticKey> toJmxStatisticKeyList(Collection<StatisticKey> in) {
        List<JmxStatisticKey> out = new ArrayList<JmxStatisticKey>();
        for (StatisticKey key : in) {
            out.add(toJmxStatisticKey(key));
        }
        return out;
    }

    public static Set<GwtStatisticDescriptor> toStatisticPublisherSet(Collection<StatisticKey> in) {
        Set<GwtStatisticDescriptor> out = new HashSet<GwtStatisticDescriptor>();
        for (StatisticKey key : in) {
            out.add(new GwtStatisticDescriptor(toJmxStatisticKey(key)));
        }
        return out;
    }

    public static StatisticDescriptor toStatisticDescriptor(GwtStatisticDescriptor in) {
        return new StatisticDescriptor(in.getJmxStatisticKey().getObjectName(),
                in.getJmxStatisticKey().getPropertyName(),
                60000L,
                in.getJmxStatisticKey().getFieldName());
    }

    public static StatisticDescriptor toStatisticDescriptor(JmxStatisticKey in) {
        return new StatisticDescriptor(in.getObjectName(),
                in.getPropertyName(),
                60000L,
                in.getFieldName());
    }

    public static JmxStatisticKey toJmxStatisticKey(StatisticEntry in) {
        return new JmxStatisticKey(in.getEnvironment(), in.getObjectName(), in.getPropertyName(), in.getMachineName(), in.getProcessName(), in.getFieldName());
    }



}
