package com.goldenjet.controller;

import com.goldenjet.entity.Customer;
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
//        return restTemplate.getForEntity("http://EUREKA-CLIENT/hello", String.class).getBody();
//        其实就是上面的封装，如果只关心响应的body信息，则使用这个方法
        return restTemplate.getForObject("http://EUREKA-CLIENT/hello", String.class);
    }
    @GetMapping("/postDemo")
    public Customer helloWorld4PostRequest(){
        Customer jet = new Customer("Jet", 26);
        // paramBody 只需要是一个 object 即可，① 普通对象，视作完整的body；② HttpEntity，可以添加header和body信息
        return restTemplate.postForObject("http://EUREKA-CLIENT/customer", jet, Customer.class);
    }
    @GetMapping("/putDemo")
    public Long helloWorld4PutRequest(){
        Customer jet = new Customer("Jet", 26);
        long id = Math.round(Math.random() * 100);
        restTemplate.put("http://EUREKA-CLIENT/customer/{1}", jet, id);
        return id;
    }

    @GetMapping("/deleteDemo")
    public Long helloWorld4DeleteRequest(){
        long id = Math.round(Math.random() * 100);
        restTemplate.delete("http://EUREKA-CLIENT/customer/{1}", id);
        return id;
    }

}
