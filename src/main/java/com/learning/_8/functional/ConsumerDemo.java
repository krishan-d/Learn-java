package com.learning._8.functional;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerDemo {
    /**
     * Consumer<T> is an in-built functional interface introduced in java 8.
     * Consumer can be used in all context where an object needs to be consumed i.e. taken as input,
     * and some operation is to be performed on the object without returning any result.
     *
     * void accept(T t);
     */

    public static void main(String[] args) {

        Consumer<Integer> consumer = System.out::println;
        consumer.accept(10);

        List<Integer> iList1 = Arrays.asList(1, 2, 3, 4);
        iList1.stream().forEach(consumer);

    }

}
