package org.unearthed.services;

/**
 * User: grant
 */
public interface CacheService {

    <K, V> String addContinuousQuery(String cacheName, CacheListener<K, V> listener, String sql);

}
