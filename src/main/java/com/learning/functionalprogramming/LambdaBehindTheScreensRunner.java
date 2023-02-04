package com.learning.functionalprogramming;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

class EvenNumberPredicate implements Predicate<Integer> {
    @Override
    public boolean test(Integer number) {
        return number % 2 == 0;
    }
}

class SystemOutConsumer implements Consumer<Integer> {
    @Override
    public void accept(Integer number) {
        System.out.println(number);
    }
}

class NumberSquareMapper implements Function<Integer, Integer> {
    @Override
    public Integer apply(Integer number) {
        return number * number;
    }
}

public class LambdaBehindTheScreensRunner {
    public static void main(String[] args) {

        Stream.of(12, 32, 17, 42, 60)
                .filter(i -> i % 2 == 0)
                .map(n -> n * n)
                .forEach(System.out::println);

        Stream.of(12, 32, 17, 42, 60)
                .filter(new EvenNumberPredicate())
                .map(new NumberSquareMapper())
                .forEach(new SystemOutConsumer());

        //1.Storing functions in variables
        //2.Passing functions to methods
        //3.Returning functions from methods

        Predicate<? super Integer> evenPredicate = createEvenPredicate();
        Predicate<? super Integer> oddPredicate = n -> n % 2 == 1;

        Stream.of(12, 32, 17, 42, 60)
                .filter(evenPredicate)
                .map(n -> n * n)
                .forEach(System.out::println);

    }

    private static Predicate<? super Integer> createEvenPredicate() {
        return n -> n % 2 == 0;
    }
}
