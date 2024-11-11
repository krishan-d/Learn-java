package com.learning._10;

import java.util.ArrayList;

public class Basics {

    public static void main(String[] args) {

        // 1. Local variable type inference:
        // Type inference is a technique used by statically typed languages, where the types of variables may be inferred from context by the compiler.

        // In JDK 10 and later, you can declare local variables with non-null initializers with the var identifier,
        // which can help you write code that’s easier to read.


        var list = new ArrayList<String>();  // infers ArrayList<String>
        var stream = list.stream();          // infers Stream<String>
        // Declaration of a local variable in java 10 using LVTI
        var s = "Hi there";

        // Declaring index variables in for loops using LVTI in Java
        for (var x = 0; x < 3; x++) {
            System.out.println(x);
        }
        System.out.println(s);

        // limitations
        // a. “var” won’t work without the initializer and not with Null

        // b. “var” cannot use with lambda express and array list because lambda expression and array list needs an explicit target type.
        // var expression = (String s) -> s.length() > 10; // error: lambda expression needs an explicit target-type
        // var arrayList = { 1, 2, 3 }; // error: array initializer needs an explicit target-type


    }
}
