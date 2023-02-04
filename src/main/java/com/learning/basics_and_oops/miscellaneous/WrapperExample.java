package com.learning.basics_and_oops.miscellaneous;

public class WrapperExample {

    public static void main(String[] args) {

        //1. Autoboxing
        int x = 10;
        //Converting int into Integer explicitly
        Integer i = Integer.valueOf(x);

        //Autoboxing i.e. compiler will write Integer.valueOf(x) internally
        Integer k = x;

        System.out.println(x + " | " + i + " | " + k);

        //2. Unboxing
        Integer l = 3;
        //Converting Integer to int explicitly
        int p = l.intValue();
        //Unboxing, now compiler will write l.intValue() internally
        int q = l;

        System.out.println(l + " | " + p + " | " + q);
    }
}
