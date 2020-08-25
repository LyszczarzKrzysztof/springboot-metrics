package com.example.simpleservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestTest {

    @GetMapping("/test")
    private String test(){
        return "hello";
    }

}
