package com.test.app.cacheapi.services;

import com.test.app.cacheapi.model.LRUCacheResponse;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CacheServiceImplTest {

    CacheServiceImpl cacheService = new CacheServiceImpl();

    @Before
    public void setUp() throws Exception {
        cacheService.setCapacity(2);
    }

    @Test
    public void shouldReturnNewEntryForGetCacheWithNewKey(){
        LRUCacheResponse actualCache = new LRUCacheResponse(1, 400);
        cacheService.createCache(1, 400);
        LRUCacheResponse expectedCache = cacheService.getCache(1);
        Assert.assertNotNull(expectedCache);
        Assert.assertEquals(expectedCache.getKey() , actualCache.getKey());
        Assert.assertEquals(expectedCache.getValue() , actualCache.getValue());
    }


    @Test
    public void shouldReturnNullWhenNoKeyAddedIntoGetCache(){
        LRUCacheResponse expectedCache = cacheService.getCache(1);
        Assert.assertEquals(expectedCache , null);
    }

    @Test
    public void shouldReturnLRUCacheResponseWithPutCache(){
        LRUCacheResponse actualCache = new LRUCacheResponse(1, 400);
        LRUCacheResponse expectedCache = cacheService.createCache(1, 400);
        Assert.assertNotNull(expectedCache);
        Assert.assertEquals(expectedCache.getKey() , actualCache.getKey());
        Assert.assertEquals(expectedCache.getValue() , actualCache.getValue());
    }


}