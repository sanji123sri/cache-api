package com.test.app.cacheapi.services;

import com.test.app.cacheapi.model.LRUCacheResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

@Service
public class CacheServiceImpl implements CacheService {

    @Value(value="${spring.application.cache}")
    private int capacity;

    private Map<Integer, LRUCacheResponse> cache;
    private LinkedList<LRUCacheResponse> dataList;

    public CacheServiceImpl() {
        this.cache = new HashMap<>();
        this.dataList = new LinkedList<>();
    }

    @Override
    public LRUCacheResponse getCache(Integer key) {
        if (cache.containsKey(key)) {
            LRUCacheResponse data = cache.get(key);
            // Remove the data from its location
            dataList.remove(data);
            // Add it to the end of the list
            dataList.add(data);
            return data;
        }
        return null;
    }

    @Override
    public LRUCacheResponse createCache(Integer key, Integer value) {
        if (cache.containsKey(key)) {
            LRUCacheResponse oldData = cache.get(key);
            // Remove old data from linkedlist
            dataList.remove(oldData);
            LRUCacheResponse newData = new LRUCacheResponse(key, value);
            // Update the value
            cache.put(key, newData);
            // Add new data at the end of the linkedlist
            dataList.add(newData);
            return newData;
        } else {
            LRUCacheResponse data = new LRUCacheResponse(key, value);
            if (cache.size() >= capacity) {
                // Remove the oldest value from both map and linkedlist
                LRUCacheResponse dataToRemoved  = dataList.pollFirst();
                cache.remove(dataToRemoved.getKey());
                cache.put(key, data);
                dataList.add(data);
                return dataToRemoved;
            }
            cache.put(key, data);
            dataList.add(data);
            return data;
        }
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
