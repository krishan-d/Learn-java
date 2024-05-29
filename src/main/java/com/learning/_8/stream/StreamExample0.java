package com.learning._8.stream;

import java.util.*;
import java.util.stream.Collectors;

public class StreamExample0 {
    /*
    Stream API:
    Stream API is used to process collections of objects.
    A stream is a sequence of objects that supports various methods which can be pipelined to produce the desired result.

    Features:
    Stream is not a data structure, instead it takes input from Collections, Arrays or I/O channels.
    Stream don't change the original data structure, only provide result as per pipelined methods.
    Each intermediate operation is lazily executed and returns a stream as a result, hence various intermediate operations can be pipelined.
    Terminal operations mark the end of the stream and return the result.

    Generating Streams:
    stream(): Returns a sequential stream considering collection as its source.
    parallelStream(): Returns a parallel Stream considering collection as its source.

    Stream Operations:
    1.Intermediate Operation: (Return Stream<T>)
        1.1 map: returns stream consisting of the results of applying the given function to thr elements of stream.
        1.2 filter: To select elements as per the Predicate passed as argument.
        1.3 sorted: To sort the stream.
        1.4 flatMap: map() + flattering
        1.5 distinct
        1.6 limit
        1.7 peek

    2.Terminal operations: (Return a result of definite type)
        2.1 collect: Return result of intermediate operations performed on the stream.
        2.2 forEach: To iterate through every element of the stream.
        2.3 reduce: To reduce the elements of a stream to a single value. Takes BinaryOperator as a parameter.
        2.4 anyMatch/allMatch/noneMatch
        2.5 count
        2.6 findAny/findFirst
        2.7 forEach
        2.8 min/max
        2.9 toArray
    */
    public static void main(String[] args) {

        /*
        1. Intermediate operations:
        */
        // 1.1 Map()
        // Stream<R> map(Stream<T> input)
        // <R> Stream<R> map(Function<? super T, ? extends R> mapper)
        // mapper function produce one value foreach input value, One-To-One mapping
        // stream.of('A', 'B', 'C') --> ('a', 'b', 'c')
        List<Integer> numbers = Arrays.asList(2, 4, 7, 1, 0);
        List<Integer> square0 = numbers.stream().map(x -> x * x).collect(Collectors.toList());
        System.out.println(square0);
        // OR
        List<Integer> square1 = numbers.stream().map(x -> x * x).toList();

        // Employee::getName - one to one mapping
        List<Employee> empList = EmployeeRepository.getUnsortedEmployeeList();
        List<String> names = empList.stream().map(Employee::getName).toList();
        System.out.println(names);

        // emp.getPhoneNumbers() - one to many mapping
        List<List<String>> phoneNumbers = empList.stream()
                .map(Employee::getPhoneNumbers)
                .toList();
        System.out.println(phoneNumbers);

        // 1.2. flatmap()
        // Stream<R> flatmap(Stream<Stream<T>> input)
        // mapper function produce multiple values for each input value, One-To-Many mapping
        // [[1, 2], [3, 4], [5, 6], [7, 8]] --> [1, 2, 3, 4, 5, 6, 7, 8]
        List<String> phoneNumbers1 = empList.stream()
                .flatMap(emp -> emp.getPhoneNumbers().stream())
                .toList();
        System.out.println(phoneNumbers1);

        // Stream.peek()
        /*
        Java Stream peek() method returns a new Stream consisting of all the elements from the original Stream after applying a given Consumer action.

        Stream peek() method is an intermediate operation.
        It returns a Stream consisting of the elements of current stream.
        It additionally perform the provided action on each element as elements.
        For parallel stream pipelines, the action may be called at whatever time and in whatever thread the element is made available by the upstream operation.
        If the action modifies shared state, it is itself responsible for providing the required synchronization.
        peek() exists mainly to support debugging, where we want to see the elements as they flow past a certain point in a pipeline.
         */
        // Stream.peek() without terminal operation
        List<Integer> iList = Arrays.asList(1, 2, 3, 4, 5);
        iList.stream()
                .peek( System.out::println );   //prints nothing

        // Stream.peek() with terminal operation
        List<Integer> newList = iList.stream()
                .peek(System.out::print)
                .collect(Collectors.toList());
        System.out.println(newList); // 12345



        //Filter
        List<Integer> required_data = numbers.stream().filter(n -> n >= 2).collect(Collectors.toList());
        System.out.println("Filtered (n>=2): " + required_data);

        //sorted
        List<Integer> sorted = numbers.stream().sorted().collect(Collectors.toList());
        System.out.println("sorted: " + sorted);

        List<Integer> reverse_sorted = numbers.stream().sorted(Comparator.reverseOrder()).toList();
        System.out.println("sorted using comparator: " + reverse_sorted);

        //limit
        System.out.println("limit: ");
        Random random = new Random();
        random.ints().limit(4).forEach(System.out::println);

        /*
        Terminal operations:
        */
        //collect
        Set<Integer> square_set = numbers.stream().map(x -> x * x).collect(Collectors.toSet());
        System.out.println("\nSet: " + square_set);

        //forEach
        numbers.stream().map(x -> x * x).forEach(System.out::println);

        //reduce
        int even_sum = numbers.stream().filter(x -> x % 2 == 0).reduce(0, (sum, i) -> sum + i);
        //Here, sum variable is assigned 0 as initial value and i is added to it.
        System.out.println("reduce: " + even_sum);


        //Parallel Processing:
        List<String> strings = Arrays.asList("Eve", "", "Hi", "I", "Parallel Processing", "");
        //count of empty string
        long count0 = strings.stream().filter(String::isEmpty).count();
        System.out.println("count (stream): " + count0);
        long count1 = strings.parallelStream().filter(String::isEmpty).count();
        System.out.println("count (parallelStream): " + count1);


        //Collectors:
        //To combine the result of processing on the elements of a stream.
        String merged_string = strings.stream().filter(s -> !s.isEmpty()).collect(Collectors.joining(", "));
        System.out.println("Merged string: " + merged_string);

        //Statistics:
        IntSummaryStatistics statistics = numbers.stream().mapToInt(i -> i).summaryStatistics();
        System.out.println("Max: " + statistics.getMax() + " Min: " + statistics.getMin());
        System.out.println("Sum: " + statistics.getSum() + " Average: " + statistics.getAverage());

    }
}
