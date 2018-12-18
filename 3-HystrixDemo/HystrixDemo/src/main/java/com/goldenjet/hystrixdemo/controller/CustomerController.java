package com.goldenjet.hystrixdemo.controller;

import com.goldenjet.hystrixdemo.entity.Customer;
import com.goldenjet.hystrixdemo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Jet on 2018/12/13.
 */
@RestController
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping("/hello")
    public Customer helloWorld(){
        return customerService.helloWorld();
    }


}
