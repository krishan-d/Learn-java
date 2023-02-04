package com.learning.basics_and_oops.strings;

/*
* Immutable Class:
* 1. Instance variable of class is final i.e. we can not change variable value after object creation.
* 2. Class is final i.e. subclass can't be created.
* 3. No setter methods i.e. have no option to change value of the instance.
* */

public final class Employee {

    private final String panNumber;

    public Employee(String panNumber) {
        this.panNumber = panNumber;
    }

    public String getPanNumber() {
        return panNumber;
    }
}

/*
* public record Employee(String panNumber) {
*     //code here
* }
* */
