package org.unearthed.services;

/**
 * User: grant
 */
public interface CacheListener<K, V> {

    void added(CacheEvent<K, V> cacheEvent);
    void updated(CacheEvent<K, V> cacheEvent);
    void removed(CacheEvent<K, V> cacheEvent);
}
