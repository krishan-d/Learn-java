package com.learning._8.lambda;

import java.util.ArrayList;
import java.util.List;

public class LambdaExpressionExample1 {

    public static void main(String[] args) {
        List<String> sList = new ArrayList<>(List.of("Eve", "Edwina", "Lyn", "Cherry"));

        System.out.println("List: " + sList);
        sList.forEach(
                n -> System.out.println(n)
        );

        System.out.println("With method reference:");
        sList.forEach(System.out::println);
    }
}
