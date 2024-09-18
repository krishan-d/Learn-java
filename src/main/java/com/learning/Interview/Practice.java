package com.learning.Interview;

import java.math.BigInteger;

public class Practice {

    public static void main(String[] args) {

        String n = "7";
        BigInteger b = new BigInteger(n);
        System.out.println(b.isProbablePrime(1) ? "prime" : "not prime");



        Object ob = new int[]{1, 2, 3};
        if(ob instanceof int[]) System.out.println("Array");
        else System.out.println("No Array!");

    }
}
