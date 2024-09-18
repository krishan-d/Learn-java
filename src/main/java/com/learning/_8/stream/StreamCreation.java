package com.learning._8.stream;

import com.learning._8.stream.model.Employee;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.time.LocalDate;
import java.time.Period;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Pattern;
import java.util.stream.*;

public class StreamCreation {
    public static void main(String[] args) throws NoSuchAlgorithmException {

        /*
         * Stream Creation:
         * Stream<T> : Generic Interface
         * */

        //1 Finite Stream
        //1.1 Empty Stream
        Stream<String> streamEmpty = Stream.empty();

        //1.2 From Values
        Stream<String> arrayStream = Stream.of("a", "b", "c");
        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 0); // from var args
        stream = Stream.of(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 0}); // from array

        Employee[] empArray = {
                new Employee(100, "Eve", 2000000),
                new Employee(102, "Edwina", 1800000)
        };

        Stream<Employee> empStream = Stream.of(empArray);

        //1.3 From Collection
        List<String> sList = Arrays.asList("A", "B", "C", "D");
        Stream<String> stream1 = sList.stream();

        Map<String, Integer> map = new HashMap<>();
        map.put("A", 1);
        Stream<Map.Entry<String, Integer>> stream2 = map.entrySet().stream();

        String[] array = sList.toArray(new String[0]);
        Stream<String> arrayFullStream = Arrays.stream(array);
        Stream<String> arrayPartStream = Arrays.stream(array, 1, 3);

        //1.4 Stream.builder()
        Stream<String> streamBuilder = Stream.<String>builder()
                .add("a").add("b").add("c")
                .build();


        //2 Infinite Stream

        /*
        2.1 Stream.generate(supplier):
        generate(supplier) – accepts a Supplier that provides an infinite series of elements which are placed in the stream.
        The limit() method can then be called in the stream chain to stop the series after a certain number of elements.
        This is suitable for generating constant streams, streams of random elements, etc.
        generate() method accepts Supplier<T> for element generation.
        As the resulting stream is infinite, developer must specify the desired size, or it will until reaches memory limit.
        */
        System.out.println(".....................");
        //create sequence of 4 strings with value 'element'
        Stream<String> streamGenerated = Stream.generate(() -> "element").limit(4);

        List<Integer> randomNumbers = Stream.generate(() -> (new Random()).nextInt(10))
                .limit(10)
                .collect(Collectors.toList());

        Stream.generate(new Random()::nextDouble).limit(10).forEach(System.out::println);
        System.out.println(".....................");

        /*
        2.2 stream.iterate():
        iterate(seed, function) – accepts two parameters – a seed which is the first term in the stream, and a function  to produce the value of the next item in the stream.
        We can limit the stream using the limit() method.
        seed(1st parameter of iterate()): 1st element of resulting stream
        While creating every following element, specified function is applied to the previous element.
        */
        Stream<Integer> streamIterated = Stream.iterate(40, n -> n + 2).limit(10);

        List<Integer> ints = IntStream.iterate(0, i -> i + 2)
                .mapToObj(Integer::valueOf)
                .limit(10)
                .collect(Collectors.toList());


        /*
        Java allows to wrap them in objects (wrapper classes) so these types can be represented as objects when required.
        The corresponding wrapper classes are Byte, Short, Integer, Long, Double, Float and Char.
        The process of converting a primitive to an object is called auto-boxing and converting an object to a primitive is called unboxing.

        3. Stream of Primitives:
        IntStream, LongStream, DoubleStream : Interfaces
        Using these interfaces alleviates unnecessary autoboxing, which allows increased productivity

        range(int startInclusive, int endExclusive): ordered stream
        rangeClosed(int startInclusive, int endInclusive) : ordered stream
        */
        // 3.1 Stream of
        IntStream stream5 = IntStream.of(1, 2, 3, 4, 5);
        LongStream stream6 = LongStream.of(1, 2, 3, 4, 5);
        DoubleStream stream7 = DoubleStream.of(1.0, 2.0, 3.0, 4.0, 5.0);

        // 3.2 Stream.range() Factory Method
        IntStream intStream = IntStream.range(1, 3);
        //A similar method rangeClosed() also returns a sequential ordered stream but the end item is inclusive in the stream.
        LongStream longStream = LongStream.rangeClosed(1, 3);

        Random random = new Random();
        DoubleStream doubleStream = random.doubles(3);

        // 3.3 Arrays.stream()
        // double[] -> Stream
        double[] doubleArray = new double[]{1.0, 2.0, 3.0, 4.0, 5.0};
        DoubleStream stream8 = Arrays.stream(doubleArray);

        // 3.4 Stream mapToInt(), mapToLong() and mapToDouble()
        List<Integer> integerList = List.of(1, 2, 3, 4, 5);
        IntStream stream9 = integerList.stream()
                .mapToInt(i -> i);

        Stream<Employee> streamOfEmployees = Stream.of(empArray);
        DoubleStream stream10 = streamOfEmployees
                .mapToDouble(Employee::getSalary);

        // 3.5 Random
        IntStream randStream = new Random().ints(5);
        randStream.forEach(System.out::println);

        random.doubles(5, 0, 0.5)
                .forEach(System.out::println);

        SecureRandom.getInstanceStrong().ints(5)
                .forEach(System.out::println);

        // 4. Finding Sum, Average, Max and Min
        // 4.1. Built-in Methods
        /*
         * All three classes, IntStream, LongStream and DoubleStream, consist of numerical values
         * and it makes sense to provide built-in support for common aggregate operations on items of the stream.
         * These classes provide the following methods for these operations. The return types are corresponding to the type of the stream.
         * The following methods are from IntStream class:
         *      sum() – returns the sum of items in the stream.
         *      average() – returns an OptionalDouble describing the arithmetic mean of items of the stream.
         *      max() – returns an OptionalInt describing the maximum item of the stream.
         *      min() – returns an OptionalInt describing the minimum item of the stream.
         *      count() – returns the count of items in the stream.
         */
        int max = IntStream.of(10, 18, 12, 70, 5)
                .max()
                .getAsInt();

        double avg = IntStream.of(1, 2, 3, 4, 5)
                .average()
                .getAsDouble();

        int sum = IntStream.range(1, 10)
                .sum();

        // 4.2 Summery Statistics
        /*
         * Another way to find the above statistical data is by using the summaryStatistics() method that returns one of the following classes:
         *
         * IntSummaryStatistics
         * LongSummaryStatistics
         * DoubleSummaryStatistics
         * Now we can use its methods to get the required value.
         *
         * getAverage()
         * getCount()
         * getMax()
         * getMin()
         * getSum()
         */
        IntSummaryStatistics summary = IntStream.of(10, 18, 12, 70, 5)
                .summaryStatistics();
        int max1 = summary.getMax();

        // 5. Primitive Stream to Object Stream / Boxed Stream
        // NEED:
        // Without boxing the stream items, we cannot perform the regular stream operations on them.
        // For example, we cannot collect the int values to a list, directly.
        Stream<Integer> boxedStream1 = IntStream.of(1, 2, 3, 4, 5).boxed();
        Stream<Long> boxedStream = LongStream.of(1, 2, 3, 4, 5).boxed();
        Stream<Double> boxedStream2 = DoubleStream.of(1.0, 2.0, 3.0, 4.0, 5.0).boxed();

        List<Integer> list = IntStream.of(1,2,3,4,5)
                .boxed()
                .collect(Collectors.toList());


        // 6. Stream of Dates:
        // 6.1. LocalDate.datesUntil() Method (Java 9)
        // startDate.datesUntil(endDate) : returns a sequential ordered stream of dates that starts from startDate (inclusive)
        // and goes to endDate (exclusive) by an incremental step of 1 day.
        // startDate.datesUntil(endDate, period) : same as above with a configured incremental step period.
        LocalDate today = LocalDate.now();
        Stream<LocalDate> next3Days = today.datesUntil(today.plusDays(3));
        next3Days.forEach(System.out::println);

        Stream<LocalDate> sameDayNext3Weeks = today
                .datesUntil(today.plusDays(21), Period.ofWeeks(1));
        sameDayNext3Weeks.forEach(System.out::println);

        // 6.2. Get Stream of Dates using Iteration (Java 8)
        Stream<LocalDate> nextThreeDays = Stream.iterate(today, d -> d.plusDays(1)).limit(3);
        List<LocalDate> dateList = nextThreeDays.collect(Collectors.toList());
        System.out.println(dateList);


        // 7. Iterate Over a Stream With Indices
        AtomicInteger index = new AtomicInteger(); // 0
        System.out.println("index: " + index);
        IntStream.range(0, empArray.length)
//              .map(i -> index.getAndIncrement())
                .filter(i -> i % 2 == 0)
                .mapToObj(i -> empArray[i])
                .forEach(System.out::println);

        Arrays.stream(empArray)
                .map(i -> index.getAndIncrement())
                .forEach(System.out::println);


        // 8. Stream of String :
        // 8.1
        IntStream streamOfChars = "abc".chars();

        // 8.2 Break a String into sub-strings according to specified RegEx
        Stream<String> streamOfString = Pattern.compile(", ").splitAsStream("a, b, c");
        System.out.println(streamOfString.toList());


        /*
        9. Stream of File:
        Files allows us to generate a Stream<String> of a text file through the "lines()" method.
        Every line of text becomes an element of the stream
        */

        try {
            Path path = Paths.get("C:\\Users");
            Stream<String> stringStream = Files.lines(path);
            Stream<String> streamWithCharset = Files.lines(path, StandardCharsets.UTF_8);

        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
