package com.learning.functionalprogramming;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

@FunctionalInterface
interface Calculator<X, Y> {
    X compute(X a, Y b);
}

public class FPFunctions {
    /*
    FP: Functions:

    1.High Order Function:
        1.1Takes one or more parameters as function
        1.2Returns a function after execution
        HOFs : Lambda Expressions and built-in Functional interfaces.

    2.Returning a Function:
        2.1High order function[HOF] can return a lambda expression and thus HOF can be used to
        create any number of functions.

    3.First Class Function:
        3.1Can be passed as a parameter to other functions
        3.2Can be returned from a function as result
        3.3Can be assigned to a variable and then can be used later

    NOTE: closest first class function in java is Lambda Expression. There are some built-in functional
    interfaces like Function, Consumer, Predicate, Supplier and so on under java.util.function package which can be used
    for functional programming.

    4.Pure Function:
        4.1Always returns a result based purely on the arguments.
        4.2Has no side effects' means, It's not modifying any state of the caller entity.

    5.Type Inference:


    */
    private static double randomVal = 0.0;

    public static void main(String[] args) {
        //High Order Function Example
        List<Integer> integerList = Arrays.asList(2, 4, 6, 7, 0);
        //Passing Function as lambda expression
        Collections.sort(integerList, (a, b) -> { return a.compareTo(b); } );
        System.out.println(integerList);

        Comparator<Integer> comparator = Integer::compareTo;
        Comparator<Integer> reverseComparator = Comparator.reverseOrder();

        //Passing a Function
        Collections.sort(integerList, reverseComparator);
        System.out.println(integerList);

        //Returning Function
        Function<Integer, Integer> add_1 = addFunction(1);
        Function<Integer, Integer> add_2 = addFunction(2);

        Integer sum = add_1.apply(7);
        System.out.println(sum);

        sum = add_2.apply(4);
        System.out.println(sum);


        //First Class Function:
        //Assigning function to a variable
        Calculator<Integer, Integer> calculator = (a, b) -> a * b;
        //Calling a function using function variable
        Integer res = calculator.compute(2, 4);
        //Pass function as a parameter
        print(calculator, 2, 4); //8
        //Get function as a return result
        Calculator<Integer, Integer> calculator1 = getCalculator();
        Integer mul = calculator1.compute(2, 4); //8
        System.out.println(mul);


        //Pure Function:

        //Impure Function
        double result1 = randomSum(2.0, 3.0);
        System.out.println("Random sum: " + result1);

    }

    static Function<Integer, Integer> addFunction(Integer i) {
        return x -> x + i;
    }

    //Function as return
    static Calculator<Integer, Integer> getCalculator (){
        return (a, b) -> a * b;
    }

    //Function as parameter
    static void print(Calculator<Integer, Integer> calculator, Integer a, Integer b) {
        System.out.println(calculator.compute(a, b));
    }

    //Pure Function
    static Integer sum(List<Integer> numbers) {
        return numbers.stream().mapToInt(Integer::intValue).sum();
    }

    //Impure Function
    static double randomSum(double a, double b) {
        randomVal = Math.random();
        return a + b + randomVal;
    }
}
