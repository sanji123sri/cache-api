package com.test.app.cacheapi.controllers;


import com.test.app.cacheapi.model.LRUCacheResponse;
import com.test.app.cacheapi.services.CacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CacheController {

    @Autowired
    CacheService cacheService;

    @GetMapping("/api/v1/get/{key}")
    @ResponseBody
    public ResponseEntity<?> getCache(@PathVariable("key") Integer key){

        LRUCacheResponse cache = cacheService.getCache(key);
        if(cache == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("");
        }
        return ResponseEntity.status(HttpStatus.OK).body(cache);
    }

    @PutMapping("/api/v1/put/{key}")
    @ResponseBody
    public ResponseEntity<?> putCache(@PathVariable final Integer key,
                                             @RequestParam(value = "value", required = true) Integer value){
        LRUCacheResponse lruCache = cacheService.createCache(key, value);

        return ResponseEntity.status(HttpStatus.CREATED).body(lruCache);
    }
}
