package com.wenjin.algorithm.test;

import lombok.Data;

@Data
public class Person {
    private Person person = new Person();

    private int age = 10;

    public Person() {
        System.out.println(age);
    }
}
