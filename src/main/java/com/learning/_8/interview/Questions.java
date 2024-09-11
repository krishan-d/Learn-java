package com.learning._8.interview;

import com.learning._8.stream.model.Department;
import com.learning._8.stream.model.User;

import java.util.*;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Questions {
    public static void main(String[] args) {

        // ex 1 : Find the first non-repeated character in a given string
        String str = "hii kriiiiish!";

        str.chars()
                .mapToObj(s -> (char) s)
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(e -> e.getValue() == 2L)
                .map(Map.Entry::getKey)
                .forEach(System.out::println);

        // or

        System.out.println(str.chars().mapToObj(e->(char)e).collect(Collectors.groupingBy(e->e,Collectors.counting()))
                .entrySet()
                .stream()
                .filter(e->e.getValue().intValue()==2)
                .collect(Collectors.toMap(Map.Entry :: getKey,Map.Entry :: getValue)).entrySet().stream()
                .map(e->e.getKey()).collect(Collectors.toList()));



        // Filtering and Mapping
        // ex 2 : Given a list of Integers, create a new list containing squares of even numbers
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7);

        List<Integer> sqList = list.stream().filter(n -> n % 2 == 0).map(n -> n * n).collect(Collectors.toList());
        System.out.println(sqList);
        // [4, 16, 36]


        // Reducing
        // ex 3 : Find some of all elements in a given integer list
        int sum = list.stream().mapToInt(n -> n).sum();
        System.out.println("sum : " + sum);
        // 28


        // Sorting
        // ex 4 : Sort a list of strings in descending order based on their length
        List<String> stringList = Arrays.asList("hi", "Edwina", "Two", "Korea", "The Universe!", "Ten");
        List<String> sortedStringList = stringList.stream().sorted(Comparator.comparing(String::length))
                .collect(Collectors.toList());
        System.out.println(sortedStringList);


        // Grouping
        // ex 5 : Group a list of employees by their department
        List<User> users = List.of(
                new User(1, "Alex", 100d, new Department(1, "HR")),
                new User(2, "Brian", 200d, new Department(1, "HR")),
                new User(3, "Charles", 900d, new Department(2, "Finance")),
                new User(4, "David", 200d, new Department(2, "Finance")),
                new User(5, "Edward", 200d, new Department(2, "Finance")),
                new User(6, "Frank", 800d, new Department(3, "ADMIN")),
                new User(7, "George", 900d, new Department(3, "ADMIN"))
        );

        Map<Department, List<User>> map = users.stream().collect(Collectors.groupingBy(User::department));
        System.out.println(map);


        // Parallel streams
        // ex 6 : use parallel stream to efficiently process a large list of numbers and find the maximum value
        OptionalInt maxVal = Stream.generate(() ->  new Random().nextInt(100)).limit(10000).parallel()
                .mapToInt(n -> n).max();
        System.out.println(maxVal);


        // Custom Collectors
        // ex 7 : create a custom collector to count occurrences of each word in a string
        String wordString = "He had been saying that he had been there";
        Stream<String> stringStream = Pattern.compile(" ").splitAsStream(wordString.toLowerCase());
        Map<String, Long> stringListMap = stringStream.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(stringListMap);


        // FlatMap
        // ex 8 : Flatten a nested list of integers into a single list
        List<List<Integer>> nestedList = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(4, 5),
                Arrays.asList(6, 7, 8)
        );
        List<Integer> flatList = nestedList.stream().flatMap(Collection::stream).collect(Collectors.toList());
        System.out.println("flatList: " + flatList);


        // Infinite Stream
        // ex 9 : Generate a infinite stream of Fibonacci numbers and take the first 10 numbers
        List<Integer> iList = Stream.iterate(new int[]{0, 1}, i -> new int[]{i[1], i[0] + i[1]})
                .limit(10)
                .map(a -> a[0])
                .toList();
        System.out.println("iList: " + iList);


        // optional
        // ex 10 : use optional to handle potential null values in a stream




        // ex 11 : Find duplicates in a list of values
        List<Integer> myList = Arrays.asList(10,15,8,49,25,98,98,32,15);
        Set<Integer> s = new HashSet<>();
        myList.stream().filter(x-> !s.add(x)).forEach(System.out::println);








    }

}
