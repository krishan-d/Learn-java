package com.learning.io_networking.serialization;

import java.io.Serializable;

public class Person implements Serializable {
    int id;
    String name;
    transient int age; //Now, it will not be serialized

    public Person(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
}
