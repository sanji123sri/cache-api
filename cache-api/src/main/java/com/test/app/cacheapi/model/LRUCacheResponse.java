package com.test.app.cacheapi.model;

public class LRUCacheResponse {

    private Integer key;
    private Integer value;


    public LRUCacheResponse(Integer key, Integer value) {
        this.key = key;
        this.value = value;
    }

    public LRUCacheResponse() {
    }

    public Integer getKey() {
        return key;
    }

    public void setKey(Integer key) {
        this.key = key;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

}
