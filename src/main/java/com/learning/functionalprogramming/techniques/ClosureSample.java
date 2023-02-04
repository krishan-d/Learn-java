package com.learning.functionalprogramming.techniques;

import java.util.function.Function;

public class ClosureSample {

    Function<Integer, Integer> add(final int x) {
        //This is a closure, i.e, a variable holding an anonymous inner class instance of the
        //Functional interface which uses variables from the outer scope.
        //The closure function instance is returned here
        return new Function<Integer, Integer>() {

            @Override
            public Integer apply(Integer integer) {
                return x + integer;
            }
        };
        //OR
        //return integer -> x + integer;
    }

    public static void main(String[] args) {
        ClosureSample sample = new ClosureSample();

        //We are curring the add method to create more variations
        var add10 = sample.add(10);
        var add20 = sample.add(20);
        var add30 = sample.add(30);

        System.out.println(add10.apply(5));

    }
}
