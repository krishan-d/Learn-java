package com.learning.functionalprogramming;

import java.util.stream.Stream;

public class MethodReferencesRunner {
    static void print(Integer number) { System.out.println(number); }

    static boolean isEven(Integer number) {
        return number % 2 == 0;
    }

    public static void main(String[] args) {

        Integer max0 = Stream.of(23,45,67,34)
                .filter(n -> n%2==0)
                .max( (n1,n2) -> Integer.compare(n1,n2) )
                .orElse(0);

        //OR
        Integer max1 = Stream.of(23, 45, 67, 34)
                .filter(MethodReferencesRunner::isEven)
                .max(Integer::compare)
                .orElse(0);

        System.out.println("max: " + max1);

        Stream.of("Hello", "Hi", "I", "Programming", "Code")
                .map(s -> s.length())
                .forEach(s -> MethodReferencesRunner.print(s));
        //OR
        System.out.println();

        Stream.of("Hello", "Hi", "I", "Programming", "Code")
                .map(String::length)
                .forEach(MethodReferencesRunner::print);

    }
}
