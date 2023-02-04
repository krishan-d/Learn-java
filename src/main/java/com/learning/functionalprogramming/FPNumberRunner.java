package com.learning.functionalprogramming;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FPNumberRunner {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(4, 6, 8, 13, 3, 17);

        //Square of 1st 10 numbers!
        IntStream.range(1, 10).map(n -> n * n).forEach(System.out::println);

        //Lowercase and print
        Stream.of("Apple", "Google", "Microsoft").map(String::toLowerCase).forEach(System.out::println);

        //Length of each element
        Stream.of("Apple", "Google", "Microsoft").map(String::length).forEach(System.out::println);

        int sum = fpSum(numbers);
        System.out.println("Functional programming sum: " + sum + " and Normal sum: " + normalSum(numbers));

    }

    public static int fpSum(List<Integer> numbers) {
        return numbers.stream()
                .reduce(0, Integer::sum);
    }

    public static int normalSum(List<Integer> numbers) {
        int sum = 0;
        for (int num : numbers)
            sum += num;
        return sum;
    }
}
