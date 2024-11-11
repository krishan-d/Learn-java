package com.learning._12;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Basics {

    public static void main(String[] args) {

        // *** NumberFormat Enhancements: Improved performance and support for currency grouping.
        // *** Collector Improvements:

        // Shenandoah Garbage Collector (Experimental): Low-latency garbage collector.
        // Microbenchmarking Suite: A suite to help developers benchmark JVM performance.
        // Switch Expressions (Preview): switch now works as an expression.
        // JVM Constant API (Incubator): API to interact with JVM constants.
        // Prompt Garbage Collection for Low-Latency Applications: Improved garbage collection responsiveness.
        // Abortable Mixed Collections for G1 GC: Allows G1 GC to abort mixed collections.
        // JFR Event Streaming (Preview): Real-time streaming of JFR events.
        // Shenandoah GC (Linux): Introduced for Linux as an experimental feature.
        // Removal of Legacy DTLS API: DTLS API was removed from JDK.


        // Compact Number Formatting:
        // Compact number formatting is a new feature introduced in Java 12 that enables the formatting of numbers
        // in a more compact and human-readable manner, appropriate for different environments.

//      NumberFormat format = NumberFormat.getCompactNumberInstance();
        NumberFormat formatter = NumberFormat.getCompactNumberInstance(Locale.US, NumberFormat.Style.LONG);
        System.out.println(formatter.format(1000)); // 1 thousand



        // Collector Improvements :

        // 1. Collectors.teeing():
        // You can use the teeing collector in Java 12 to do two different things on a stream,
        // and then use a function to combine them into one result.
        var sum = IntStream.rangeClosed(0, 10).boxed().collect(Collectors.toList()).stream()
                .collect(Collectors.teeing(
                        Collectors.summingInt(Integer::intValue),
                        Collectors.counting(),
                        (total, count) -> total / count
                ));
        System.out.println(sum); // 5


        // 2. Collectors.filtering():
        // Filters stream elements based on a predicate before applying a collector to the filtered elements.
        // Useful for filtering elements while collecting them.
        List<Integer> list = List.of(1, 2, 3, 4, 5, 6);
        Set<Integer> result = list.stream()
                .collect(Collectors.filtering(
                        i -> i % 2 == 0, // Predicate: filter words starting with 'b'
                        Collectors.toSet() // Collector: collect into a Set
                ));


        // 3. Collectors.toMap():
        // Now allows handling duplicate keys using a merge function.


    }
}
