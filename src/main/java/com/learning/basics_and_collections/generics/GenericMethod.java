package com.learning.basics_and_collections.generics;

public class GenericMethod {

    public static <T> boolean isEqual(GenericType<T> g1, GenericType<T> g2) {
        return g1.getVal().equals(g2.getVal());
    }

    public static void main(String[] args) {
        GenericType<String> s1 = new GenericType<>();
        s1.setVal("Hello");

        GenericType<String> s2 = new GenericType<>();
        s1.setVal("Hello");

        boolean equal = GenericMethod.<String>isEqual(s1, s2);
        equal = GenericMethod.isEqual(s1, s2); //Type Inference
        System.out.println("isEqual: " + equal);

    }
}
