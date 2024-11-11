package com.learning._9;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Basics {

    public static void main(String[] args) throws IOException {

        // 1. Factory methods for collections(like List, Map, Set and Map.Entry) :

        /*
        A collection factory method in Java is a static method that provides a simple way of initializing an immutable Collection<E>.
        Being immutable, no elements can be added to, removed from, or modified inside the Collection<E> after it is initialized.
        */

        // Empty List example:
        List immutableEmptyList = List.of();

        // Non-Empty List example:
        List immutableList = List.of("Abc", "Def", "Ghi");

        // Empty Map Example:
        Map emptyImmutableMap = Map.of();
        // emptyImmutableMap ==> {};

        // Non-Empty Map Example:
        Map nonemptyImmutableMap = Map.of(1, "one", 2, "two", 3, "three");
        // nonemptyImmutableMap ==> {2=two, 3=three, 1=one}



        // 2. Private Interface Methods
        // From Java 9, we can create private methods inside an interface that help to share common code
        // between non-abstract methods.


        // 3. Stream API Improvements:
        // The takeWhile and dropWhile methods are an important feature since they let you take or drop components from a stream depending on a predefined condition.
        // takeWhile method: allows you to take elements from a stream as long as a specified condition is met.
        // dropWhile method: allows you skip elements until the specified condition becomes false.

        List<Integer> numbers = IntStream.range(1, 20).boxed().toList();

        List<Integer> takenList = numbers.stream().takeWhile(n -> n > 10).collect(Collectors.toList());

        List<Integer> droppedList = numbers.stream().dropWhile(n -> n > 10).collect(Collectors.toList());


        // 4. Modules



        // 5. Try With Resources Improvements:
        // Java 9 allows you to declare and initialize resources directly in the try-with-resources statement, reducing code redundancy.
        // Comparison with previous versions: In previous versions of Java, you had to declare and
        // initialize resources outside of the try block, which made your code more verbose.

        FileOutputStream fos = new FileOutputStream("resource.txt");
        // Before Java 9
        try (FileOutputStream localFos = fos) {
            localFos.write("hello".getBytes());
        }
        // Improvements
        try (fos) { // no need to declare resource locally
            fos.write("hello".getBytes());
        }


    }
}
