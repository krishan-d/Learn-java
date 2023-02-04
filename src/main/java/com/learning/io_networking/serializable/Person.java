package com.learning.io_networking.serializable;

import java.io.Serializable;

public class Person implements Serializable {
    private static final long serialVersionUID = 1L;
    /*
    Used to ensure compatibility between different versions of a serializable class.
    It acts as a version identifier for a class, ensuring that objects serialized by one version of the class can be
    deserialized by another version of the class, even if the class has been modified.
    */
    int id;
    String name;
    transient int income; //Now, it will not be serialized

    public Person(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.income = age;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getIncome() {
        return income;
    }
}
