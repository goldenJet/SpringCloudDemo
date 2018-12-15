package com.goldenjet.controller;

import com.goldenjet.entity.Customer;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Jet on 2018/12/15.
 */
@RestController
public class CustomerController {

    @PostMapping("/customer")
    public Customer helloWorld4PostRequest(@RequestBody Customer customer){
        long id = Math.round(Math.random() * 100);
        customer.setId(id);
        System.out.println("helloWorld4PostRequest");
        return customer;
    }

    @PutMapping("/customer/{customerId}")
    public int helloWorld4PutRequest(@RequestBody Customer customer, @PathVariable("customerId") long customerId){
        System.out.println("helloWorld4PutRequest");
        return 1;
    }

    @DeleteMapping("/customer/{customerId}")
    public int helloWorld4DeleteRequest(@PathVariable("customerId") long customerId){
        System.out.println("helloWorld4DeleteRequest");
        return 1;
    }

}
