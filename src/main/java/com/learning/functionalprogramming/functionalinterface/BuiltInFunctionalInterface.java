package com.learning.functionalprogramming.functionalinterface;

import java.util.Optional;
import java.util.stream.Stream;

public class BuiltInFunctionalInterface {
    /*
    Built-in Functional Interface:

    Consumer<T> : Accepts an object and returns nothing.
    Producer<T> : Accepts nothing and return an object.
    Predicate<T> : Accept an object and returns a boolean.
    Function<T, R> : Accepts an object and returns another object.
    */
    public static void main(String[] args) {

        //Common usage
        //1.Stream and Optional API
        Stream.of("Hi", "Eve", "How", "Are", "You")
                .filter(s -> s.equals("Hi") || s.equals("Are")) //Predicate
                .map(s -> s + " String") //Function
                .forEach(System.out::println); //Consumer

        Optional.of("Hi")
                .filter(s -> s.equals("Hi") || s.equals("Are"))
                .map(s -> s + " String")
                .ifPresent(System.out::println);

        //2.Reactive Library
        //Java reactive libraries, RxJava and Reactor, are both based on Stream API,
        //which means they also use functional interfaces in their code.
    }
}
