package com.example.springbootmetrics;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Component
@Endpoint(id = "test-connector")
public class TestConnector {

    @ReadOperation
    public Map<String,String> get() {
        Map<String,String> map = new HashMap<>();
        RestTemplate restTemplate = new RestTemplate();
        try {
            restTemplate.exchange("http://localhost:8081/test", HttpMethod.GET, HttpEntity.EMPTY, String.class);
            map.put("status", "ok");
        }catch (Exception e){
            map.put("status", "failed");
        }
        return map;
    }
}
