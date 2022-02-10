package com.prdcv.learnspring.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheckRest {
    @GetMapping(path="/health")
    public String showHeath(){
        return "Good";
    }
}
