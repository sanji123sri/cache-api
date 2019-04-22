package com.test.app.cacheapi.controllers;

import com.test.app.cacheapi.model.LRUCacheResponse;
import com.test.app.cacheapi.services.CacheService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(CacheController.class)
public class CacheControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    CacheService cacheService;

    @Test
    public void shouldGetLRUCacheResponseWith200Ok() throws Exception {
        when(cacheService.getCache(Mockito.anyInt())).thenReturn(new LRUCacheResponse(1, 400));
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1/get/{key}", 1);
        mockMvc.perform(requestBuilder).andExpect(status().isOk());
    }

    @Test
    public void shouldGetStatusCode404NotFoundWhenLRUCAcheResponseIsEmpty() throws Exception {
        when(cacheService.getCache(1)).thenReturn(null);
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1/get/{key}", 1);
        mockMvc.perform(requestBuilder).andExpect(status().isNotFound());
    }

    @Test
    public void shouldPutLRUCacheResponseWith200Ok() throws Exception {
        when(cacheService.createCache(1, 400)).thenReturn(new LRUCacheResponse(1, 400));
        RequestBuilder requestBuilder = MockMvcRequestBuilders.put("/api/v1/put/{key}", 1).param("value", "400");
        mockMvc.perform(requestBuilder).andExpect(status().isCreated());
    }



}