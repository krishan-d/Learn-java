package com.learning._8.stream;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamExample6 {

    public static void main(String[] args) {

        /**
         * Getting the Last Item of a Stream
         */

        // 1. Getting Last Item with Stream Reduction

        // If the Stream is empty
        Stream<Integer> emptyStream = Stream.empty();
        // Return -1 if stream is empty
        Integer lastElement = emptyStream.reduce((first, second) -> second).orElse(-1);
        System.out.println(lastElement);  //-1

        // Throw IllegalStateException if stream is empty
        /* Integer lastElement = emptyStream.reduce((first, second) -> second)
                .orElseThrow(() -> new IllegalStateException("no last element"));*/


        // 2. Using Streams.findLast() from Guava
        // Streams.findLast() example
        /* Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
        Integer lastElement1 = Streams.findLast(stream).orElse(-1);
        System.out.println(lastElement1); */  // Prints 9

        // 3. Last Item from an Infinite streams
        Stream<Integer> infiniteStream = Stream.iterate(0, n -> n + 2);
        lastElement = infiniteStream.limit(100)
                .reduce((first, second) -> second)
                .orElse(-1);
        System.out.println(lastElement);   //198


        /**
         * Find, Count and Remove Duplicates
         */
        // 1. Stream.distinct() – To Remove Duplicates
        List<String> list = Arrays.asList("A", "B", "C", "D", "A", "B", "C");
        List<String> distinctItems = list.stream()
                .distinct()
                .collect(Collectors.toList());
        System.out.println(distinctItems);

        // 2. Collectors.toSet() – To Remove Duplicates
        ArrayList<Integer> numbersList = new ArrayList<>(Arrays.asList(1, 1, 2, 3, 3, 3, 4, 5, 6, 6, 6, 7, 8));
        Set<Integer> setWithoutDuplicates = numbersList.stream()
                .collect(Collectors.toSet());
        System.out.println(setWithoutDuplicates);

        // 3. Collectors.toMap() – To Count Duplicates
        Map<Integer, Long> elementCountMap = numbersList.stream()
                .collect(Collectors.toMap(Function.identity(), v -> 1L, Long::sum));
        System.out.println(elementCountMap);


        /**
         * Sorting a Stream by Multiple Fields
         * sort the streams of objects by multiple fields using Comparators and Comparator.thenComparing() method.
         * This method returns a lexicographic-order comparator with another comparator. It gives the same effect as SQL GROUP BY clause.
         */
        /*
        1. Creating Comparators for Multiple Fields
        To sort on multiple fields, we must first create simple comparators for each field on which we want to sort the stream items. Then we chain these Comparator instances in the desired order to give GROUP BY effect on complete sorting behavior.

        Note that Comparator provides a few other methods that we can use if they fit in the requirements.

        thenComparing(keyExtractor) :
        thenComparing(comparator)
        thenComparing(keyExtractor, comparator)
        thenComparingDouble(keyExtractor)
        thenComparingInt(keyExtractor)
        thenComparingLong(keyExtractor)
         */

        // Joining Multiple Comparators
        List<Employee> unsortedEmpList = EmployeeRepository.getUnsortedEmployeeList();
        // name comparator
        Comparator<Employee> compareByFirstName = Comparator.comparing( Employee::getName );
        // salary comparator
        Comparator<Employee> compareByLastName = Comparator.comparing( Employee::getSalary );
        //Compare by first name and then last name (multiple fields)
        Comparator<Employee> compareByNameSalary = compareByFirstName.thenComparing(compareByLastName);
        //Using Comparator - pseudo code
        List<Employee> sortedEmpList = unsortedEmpList.stream().sorted( compareByNameSalary ).toList();
        System.out.println(sortedEmpList);


        /**
         * Sort a Stream
         * sort streams of numbers, strings and custom types in ascending (natural order) and descending orders (reverse order) in Java.
         */
        // 1. Basics of Sorting the Streams
        // The Stream interface provides the sorted() method that returns a stream consisting of the elements of a given stream, sorted according to the natural order. It is an overloaded method:
        // Stream sorted(): sorted according to natural order.
        // Stream sorted(comparator): sorted according to the provided Comparator.

        Stream<Employee> unsortedStream = unsortedEmpList.stream();
        //Default Ordering
        List<Employee> sortedList = unsortedStream.sorted().toList();
        //Order by First Name
        List<Employee> sortedByNameList = unsortedStream.sorted(Comparator.comparing(Employee::getName)).toList();
        List<Employee> reversedSortedByNameList = unsortedStream.sorted(Comparator.comparing(Employee::getName).reversed()).toList();

        // 2. Sorting Stream of Numbers
        Stream<Integer> numStream = Stream.of(1,3,5,4,2);
        numStream.sorted( Comparator.reverseOrder() )
                .forEach(System.out::println);

        // 3. Sorting Stream of String
        Stream<String> wordStream = Stream.of("A","C","E","B","D");
        wordStream.sorted()									//ascending
                .forEach(System.out::println);
        wordStream.sorted( Comparator.reverseOrder() )		//descending
                .forEach(System.out::println);


        /**
         * Predicate chaining
         */
        Predicate<Employee> idLessThan2 = e -> e.getId() < 2;

        Predicate<Employee> salaryGreaterThan500 = e -> e.getSalary() > 500;

        List<Employee> filteredEmployees = unsortedEmpList.stream()
//              .filter( idLessThan2.or( salaryGreaterThan500 ) )
                .filter( idLessThan2.and( salaryGreaterThan500 ) )
                .collect(Collectors.toList());
        System.out.println(filteredEmployees);

        // 1. Predicate negate() Method
        Predicate<Integer> isEven = i -> i % 2 == 0;
        Predicate<Integer> isOdd = isEven.negate();

        // 2. Predicate not() Method – Java 11
        Predicate<Integer> isOdd11 = Predicate.not( isEven );


        /**
         * Finding Max and Min from List using Streams
         */
        // Stream.max(comparator) : It is a terminal operation that returns the maximum element of the stream according to the provided Comparator.
        // Stream.min(comparator) : It is a terminal operation that returns the minimum element of the stream according to the provided Comparator.

        LocalDate start = LocalDate.now();
        LocalDate end = LocalDate.now().plusMonths(1).with(TemporalAdjusters.lastDayOfMonth());
        // Create stream of dates
        List<LocalDate> dates = Stream.iterate(start, day -> day.plusDays(1))
                .limit(ChronoUnit.DAYS.between(start, end))
                .toList();

        LocalDate maxDate = dates.stream()
                .max( Comparator.comparing( LocalDate::toEpochDay ) )
                .get();

        LocalDate minDate = dates.stream()
                .min( Comparator.comparing( LocalDate::toEpochDay ) )
                .get();

        Integer maxNumber = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9)
                .max(Comparator.comparing(Integer::valueOf))
                .get();

        Integer minNumber = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9)
                .min(Comparator.comparing(Integer::valueOf))
                .get();

    }
}
