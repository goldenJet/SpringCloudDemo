package com.goldenjet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Jet on 2018/12/13.
 */
@RestController
public class CustomerController {

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/hello")
    public String helloWorld(){
        return restTemplate.getForEntity("http://EUREKA-CLIENT/hello", String.class).getBody();
    }

}
