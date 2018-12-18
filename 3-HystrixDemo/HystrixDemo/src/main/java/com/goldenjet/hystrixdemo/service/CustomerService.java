package com.goldenjet.hystrixdemo.service;

import com.goldenjet.hystrixdemo.entity.Customer;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Jet on 2018/12/18.
 */
@Service
public class CustomerService {

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(defaultFallback = "helloFallback")
    public Customer helloWorld(){
        long t1 = System.currentTimeMillis();
        Customer jet = restTemplate.postForObject("http://EUREKA-CLIENT/hystrixDemo", new Customer("jet", 26), Customer.class);
        long t = System.currentTimeMillis() - t1;
        System.out.println(t);
        return jet;
    }

    public Customer helloFallback(){
        return new Customer("error", 1);
    }

}
