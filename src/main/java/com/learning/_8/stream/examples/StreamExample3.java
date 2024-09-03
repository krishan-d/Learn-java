package com.learning._8.stream.examples;

import java.util.stream.Stream;

public class StreamExample3 {
    public static void main(String[] args) {
        /*
        Stream improvements in Java 9
        */

        //takeWhile
        //Takes element from a stream while given condition is true.
        //The moment condition becomes false, it quits and return a new stream with matched elements.
        System.out.println("takeWhile: ");
        Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0)
                .takeWhile(x -> x <= 5)
                .forEach(System.out::println);

        System.out.println("filter: ");
        Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0)
                .filter(x -> x <= 5)
                .forEach(System.out::println);

        //dropWhile
        //Similar to takeWhile() but reverse
        //dropWhile() drops element while condition is true
        System.out.println("dropWhile: ");
        Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0)
                .dropWhile(x -> x <= 5)
                .forEach(System.out::println);

        //iterate
        System.out.println("iterate: ");
        Stream.iterate(1, i -> i < 10, i -> i * 2).forEach(System.out::println);
        //OR
        System.out.println("similar for loop:");
        for (int i = 1; i < 10; i *= 2) System.out.println(i);

        //ofNullable
        //To avoid dreaded NullPointerException and cleaner code
        Integer number = null;
        Stream<Integer> stream = number != null ? Stream.of(number) : Stream.empty();
        //OR using ofNullable

        System.out.println("ofNullable: ");
        Stream.ofNullable(number).map(i -> i * i).forEach(System.out::println);


    }

}
