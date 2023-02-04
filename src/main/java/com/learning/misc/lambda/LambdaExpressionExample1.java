package com.learning.misc.lambda;

import java.util.ArrayList;
import java.util.List;

public class LambdaExpressionExample1 {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>(List.of("Eve", "Edwina", "Lyn", "Cherry"));

        System.out.println("List: " + list);
        list.forEach(
                (n) -> System.out.println(n)
        );

        System.out.println("With method reference:");
        list.forEach(System.out::println);
    }
}
