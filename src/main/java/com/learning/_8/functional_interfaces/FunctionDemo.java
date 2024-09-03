package com.learning._8.functional_interfaces;

import java.util.function.Function;

public class FunctionDemo {
    public static void main(String[] args) {

        // java.util.function
        // Function<T, R> : T - input type, R - return type
        Function<Integer, Double> divide = n -> n / 2.0;

        // R apply(T t)
//        System.out.println(divide.apply(10));

        /* andThen():
         * default <V> Function<T, V> andThen(Function<? super R, ? extends V> after)
         * It returns a composed function wherein the parameterized function will be executed after the first one.
         * If evaluation of either function throws an error, it is relayed to the caller of the composed function.
         */
//        divide = divide.andThen(a -> 3 * a);

        /* compose():
         * default <V> Function<V, R> compose(Function<? super V, ? extends T> before)
         * It returns a composed function wherein the parameterized function will be executed first and then the first one.
         * If evaluation of either function throws an error, it is relayed to the caller of the composed function.
         */
        divide = divide.compose(a -> 3 * a);

        System.out.println(divide.apply(10)); // 15.0


        // static <T> Function<T, T> identity()
        /*
         * where T denotes the type of the argument and the value to be returned
         * Returns: This method returns a function that returns its own argument
         */
        Function<Integer, Integer> i = Function.identity();
        System.out.println(i.apply(10)); // 10


    }
}
