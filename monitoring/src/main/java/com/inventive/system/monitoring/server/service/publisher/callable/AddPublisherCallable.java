package com.inventive.system.monitoring.server.service.publisher.callable;

import com.inventive.system.monitoring.gwt.client.statistics.dto.JmxStatisticKey;
import com.inventive.system.monitoring.gwt.server.service.statistics.ConversionUtils;
import com.inventive.system.monitoring.server.service.publisher.StatisticPublisher;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Required;

import java.io.Serializable;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Set;
import java.util.concurrent.Callable;

/**
 * User: grant
 */
public class AddPublisherCallable implements Callable<Boolean>, Serializable {

    private static transient final Log log = LogFactory.getLog(AddPublisherCallable.class);

    private static transient Set<StatisticPublisher> statisticPublishers;

    private JmxStatisticKey jmxStatisticKey;

    private static transient String machineName;

    private AddPublisherCallable() {
    }

    public AddPublisherCallable(JmxStatisticKey jmxStatisticKey) {
        this.jmxStatisticKey = jmxStatisticKey;
    }

    @Override
    public Boolean call() throws Exception {
        if (null != statisticPublishers) {
            if (jmxStatisticKey.getMachineName() == null || jmxStatisticKey.getMachineName().equals(getMachineName())) {
                for (StatisticPublisher statisticPublisher : statisticPublishers) {
                    statisticPublisher.addDescriptor(ConversionUtils.toStatisticDescriptor(jmxStatisticKey));
                }
            }
        }
        return null;
    }

    private static String getMachineName() {
        if (null == machineName) {
            try {
                machineName = InetAddress.getLocalHost().getHostName();
            } catch (UnknownHostException e) {
                log.error(e);
                return null;
            }
        }
        return machineName;
    }


    @Required
    public void setStatisticPublishers(Set<StatisticPublisher> statisticPublishers) {
        AddPublisherCallable.statisticPublishers = statisticPublishers;
    }
}
