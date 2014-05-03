package com.inventive.system.monitoring.gwt.client.statistics.dto;

import com.google.gwt.user.client.rpc.IsSerializable;
import com.inventive.system.monitoring.gwt.client.dnd.HasPosition;

import java.util.List;

/**
 * User: grant
 */
public class Chart implements IsSerializable, HasPosition {

    private Integer id;
    private String title;
    private int row=0;
    private int column=0;
    private List<JmxStatisticKey> keys;

    public Chart() {
    }

    public Chart(Integer id) {
        this.id = id;
    }

    public Chart(Integer id, List<JmxStatisticKey> keys) {
        this.id = id;
        this.keys = keys;
    }

    public String getTitle() {
        return title;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<JmxStatisticKey> getKeys() {
        return keys;
    }

    public void setKeys(List<JmxStatisticKey> keys) {
        this.keys = keys;
    }

    @Override
    public int getColumn() {
        return column;
    }

    @Override
    public void setPosition(int row, int column) {
        this.row = row;
        this.column = column;
    }

    @Override
    public int getRow() {
        return row;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Chart chart = (Chart) o;

        if (id != null ? !id.equals(chart.id) : chart.id != null) return false;
        if (keys != null ? !keys.equals(chart.keys) : chart.keys != null) return false;
        if (title != null ? !title.equals(chart.title) : chart.title != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (keys != null ? keys.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Chart");
        sb.append("{id=").append(id);
        sb.append(", title='").append(title).append('\'');
        sb.append(", keys=").append(keys);
        sb.append('}');
        return sb.toString();
    }
}
