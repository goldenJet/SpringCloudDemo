package com.goldenjet.entity;

import lombok.Data;

/**
 * Created by Jet on 2018/12/15.
 */
@Data
public class Customer {
    public long id;
    public String name;
    public int age;

    public Customer(){}

    public Customer(String name, int age){
        this.name = name;
        this.age = age;
    }
}
