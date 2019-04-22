package com.test.app.cacheapi.services;

import com.test.app.cacheapi.model.LRUCacheResponse;

public interface CacheService {

    LRUCacheResponse getCache(Integer key);

    LRUCacheResponse createCache(Integer key, Integer value);

}
