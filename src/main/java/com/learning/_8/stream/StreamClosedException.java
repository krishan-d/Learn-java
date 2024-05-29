package com.learning._8.stream;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamClosedException {

    /**
     * [Solved] “Stream has already been operated upon or closed” Exception
     */
    public static void main(String[] args) {

        Stream<Integer> numberStream = Stream.of(123, 234, 11, 57, 60, -4);
        /*List<Integer> evenNumbers = numberStream
                .filter(integer -> integer % 2 == 0)
                .toList();

        List<Integer> oddNumbers = numberStream  // stream has already been operated upon or closed
                .filter(integer -> integer % 2 == 1)
                .toList();
        */

        // Resolution
        Supplier<Stream<Integer>> streamSupplier = () -> Stream.of(123, 234, 11, 57, 60, -4);
        List<Integer> evenNumbers = streamSupplier.get()
                .filter(integer -> integer % 2 == 0)
                .collect(Collectors.toList());
        System.out.println(evenNumbers);

        List<Integer> oddNumbers = streamSupplier.get()
                .filter(integer -> integer % 2 == 1)
                .collect(Collectors.toList());
        System.out.println(oddNumbers);

    }
}
