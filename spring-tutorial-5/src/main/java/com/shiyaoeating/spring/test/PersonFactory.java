package com.shiyaoeating.spring.test;

public class PersonFactory {
    public Person createPerson(int id, String name) {
        System.out.println("Using factory to crease Person");
        return new Person(id, name);
    }
}
