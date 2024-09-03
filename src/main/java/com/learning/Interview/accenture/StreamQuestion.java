package com.learning.Interview.accenture;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamQuestion {
    public static void main(String[] args) {

        List<Integer> iL = Stream.iterate(1, n -> n + 1)
                .limit(700)
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());

        System.out.println(iL);

        Stream.iterate(18, n -> n + 18).limit(10).forEach(System.out::println);


        int[] numbers = {1, 2, 3};
        int target = 4;
        int i = 0;
        int k = numbers.length - 1;
        Set<Integer> s1 = new HashSet<>();
        while (i < k) {
            if (numbers[i] + numbers[k] == target) {
                s1.add(i);
                s1.add(k);
                i++; k--;
            } else if (numbers[i] + numbers[k] < target) {
                i++;
            } else {
                k--;
            }
        }

        System.out.println(s1);

        /* int[] arr = IntStream.range(0, numbers.length)
                             .boxed()
                             .flatMap(i -> IntStream.range(i + 1, numbers.length)
                                                    .filter(j -> numbers[i] + numbers[j] == target)
                                                    .mapToObj(j -> new int[] {i, j}))
                             .flatMapToInt(Arrays::stream)
                             .toArray(); */

        /* Set<Integer> s = IntStream.range(0, numbers.length)
                            .boxed()
                            .flatMap(i -> IntStream.range(i + 1, numbers.length)
                                    .filter(j -> numbers[i] + numbers[j] == target)
                                    .mapToObj(j -> Set.of(i, j)))
                            .flatMap(Set::stream)
                            .collect(Collectors.toSet()); */

        if (s1.isEmpty()) {
//            new int [] {-1,-1};
        }
        int[] arr = s1.stream().mapToInt(Integer::intValue).toArray();
        System.out.println(Arrays.toString(arr));


        int [] num = {1, 2, 3, 4, 2, 1};
        List<Integer> v = Arrays.stream(num).boxed().distinct().toList();
        System.out.println("v: " + v);

    }
}

class MyCustomException extends Exception {

    MyCustomException(String message) {
        super(message);
    }

    @Override
    public String toString() {
        return "MyCustomException{}";
    }
}
