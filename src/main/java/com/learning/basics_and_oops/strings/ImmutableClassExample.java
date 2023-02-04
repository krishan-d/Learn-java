package com.learning.basics_and_oops.strings;

public class ImmutableClassExample {

    public static void main(String[] args) {
        Employee e = new Employee("ABC123E");
        String p = e.getPanNumber();
        System.out.println("Pan Card Number : " + p);
    }
}

