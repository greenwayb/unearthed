package org.unearthed.services;

/**
 * User: grant
 */
public class CacheEvent<K, V> {

    private CacheEventType eventType;
    private K key;
    private V oldValue;
    private V newValue;

    protected CacheEvent() {
    }

    public CacheEvent(CacheEventType eventType, K key, V oldValue, V newValue) {
        this.eventType = eventType;
        this.key = key;
        this.oldValue = oldValue;
        this.newValue = newValue;
    }

    public CacheEventType getEventType() {
        return eventType;
    }

    public void setEventType(CacheEventType eventType) {
        this.eventType = eventType;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getOldValue() {
        return oldValue;
    }

    public void setOldValue(V oldValue) {
        this.oldValue = oldValue;
    }

    public V getNewValue() {
        return newValue;
    }

    public void setNewValue(V newValue) {
        this.newValue = newValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CacheEvent that = (CacheEvent) o;

        if (eventType != that.eventType) return false;
        if (key != null ? !key.equals(that.key) : that.key != null) return false;
        if (newValue != null ? !newValue.equals(that.newValue) : that.newValue != null) return false;
        if (oldValue != null ? !oldValue.equals(that.oldValue) : that.oldValue != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = eventType != null ? eventType.hashCode() : 0;
        result = 31 * result + (key != null ? key.hashCode() : 0);
        result = 31 * result + (oldValue != null ? oldValue.hashCode() : 0);
        result = 31 * result + (newValue != null ? newValue.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "CacheEvent{" +
                "eventType=" + eventType +
                ", key=" + key +
                ", oldValue=" + oldValue +
                ", newValue=" + newValue +
                '}';
    }
}
