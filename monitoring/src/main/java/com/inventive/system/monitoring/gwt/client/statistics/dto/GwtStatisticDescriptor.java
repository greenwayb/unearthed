package com.inventive.system.monitoring.gwt.client.statistics.dto;

import com.google.gwt.user.client.rpc.IsSerializable;
import com.google.gwt.view.client.ProvidesKey;

/**
 * User: grant
 */
public class GwtStatisticDescriptor implements IsSerializable {

    public static final ProvidesKey<GwtStatisticDescriptor> KEY_PROVIDER = new ProvidesKey<GwtStatisticDescriptor>() {
      @Override
      public Object getKey(GwtStatisticDescriptor item) {
        return item == null ? null : item.getJmxStatisticKey();
      }
    };

    private JmxStatisticKey jmxStatisticKey;

    public GwtStatisticDescriptor() {
    }

    public GwtStatisticDescriptor(JmxStatisticKey jmxStatisticKey) {
        this.jmxStatisticKey = jmxStatisticKey;
    }

    public JmxStatisticKey getJmxStatisticKey() {
        return jmxStatisticKey;
    }

    public void setJmxStatisticKey(JmxStatisticKey jmxStatisticKey) {
        this.jmxStatisticKey = jmxStatisticKey;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GwtStatisticDescriptor that = (GwtStatisticDescriptor) o;

        if (jmxStatisticKey != null ? !jmxStatisticKey.equals(that.jmxStatisticKey) : that.jmxStatisticKey != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        return jmxStatisticKey != null ? jmxStatisticKey.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "StatisticPublisher{" +
                "jmxStatisticKey=" + jmxStatisticKey +
                '}';
    }
}
