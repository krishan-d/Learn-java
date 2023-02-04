package com.learning.functionalprogramming;

import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public class FPTechniques {
    /*
    Functional programming Techniques:
    1.Composition:
    A technique where multiple functions are combined to a single function.

    2.Eager vs Lazy Evaluation:
    Eager evaluation: expression is evaluated as soon as it is encountered.
    Lazy evaluation or non-strict evaluation is the process of delaying evaluation of
    an expression until it is needed.
    In general, java does strict evaluation but operands like &&, || and ? : it does a Lazy evaluation.

    3.Persistent Data Structure
    Capable of maintaining its previous updates as separate versions and each version can be accessed and
    updated accordingly.
    This makes data structure immutable and thread-safe. Example - String

    4.Recursion:
    Functional programming favors recursion over looping. In java this can be achieved by using
    stream API or by writing recursive function.

    */
    public static void main(String[] args) {

        //Composition
        //Predicate provide and() and or() method to combine functions.
        Predicate<String> hasName = s -> s.contains("name");
        Predicate<String> hasPassword = p -> p.contains("password");
        Predicate<String> hasNameAndPass = hasName.and(hasPassword);
        String query = "name=Eve;password=Test";
        System.out.println(hasNameAndPass.test(query));

        //Function provides compose() and andThen() methods.
        Function<Integer, Integer> mul = x -> x * 3;
        Function<Integer, Integer> add = x -> x + 3;
        Function<Integer, Integer> firstAddThenMultiply = mul.compose(add);
        Function<Integer, Integer> firstMultiplyThenAdd = mul.andThen(add);

        System.out.println(firstAddThenMultiply.apply(3)); //18
        System.out.println(firstMultiplyThenAdd.apply(3)); //12


        //Eager vs Lazy Evaluation:
        //Eager
        System.out.println(multiplyOrAdd(true, sum(4), multiply(4)));
        //Lazy
        //This is a Lambda expression behaving as a closure
        UnaryOperator<Integer> sum = i -> {
            System.out.println("Executing add");
            return i + i;
        };
        UnaryOperator<Integer> multiply = i -> {
            System.out.println("Executing multiply");
            return i * i;
        };
        //Lambda closures are passed instead of plan functions
        System.out.println(addOrMultiply(true, sum, multiply, 4));

        //NOTE: A closure is a function which is a combination of function along with its surrounding state.


    }

    static int sum(int x) {
        System.out.println("Executing add");
        return x + x;
    }
    static int multiply(int x) {
        System.out.println("Executing multiply");
        return x * x;
    }
    //This is Higher-Order-Function
    static <T, R> R addOrMultiply(boolean add, Function<T, R> onAdd, Function<T, R> onMultiply, T t) {
        //Java evaluates expression on ?: lazily hence only the required method is executed
        return (add ? onAdd.apply(t) : onMultiply.apply(t));
    }

    static int multiplyOrAdd(boolean add, int onAdd, int onMultiply) {
        return add ? onAdd : onMultiply;
    }

    //Persistent way
    public static Person updateAge(Person person, int age) {
        Person person1 = new Person();
        person1.setAge(age);
        return person1;
    }
    //Non-Persistent way
    public static Person changeAge(Person person, int age) {
        person.setAge(age);
        return person;
    }

    static class Person {
        int age;
        public int getAge() { return age; }
        public void setAge(int age) { this.age = age; }
    }



}
