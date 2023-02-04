package com.learning.basicsll_and_collections.generics;

import java.util.*;

public class GenericsDemo {
    //Generic method
    public static <E> void printArray(E[] inputArray) {
        // Display array elements
        for (E element : inputArray) {
            System.out.printf("%s ", element);
        }
        System.out.println();
    }

    public static void main(String[] args) {

        //Type inference
        Box<Integer> integerBox = new Box<>();
        //<> is Type inference, compiler will infer the type that is needed

        //unchecked conversion warning
        Box<String> stringBox = new Box<String>();

        integerBox.add(10);
        stringBox.add("Hi Eve!");

        System.out.printf("Integer Value :%d\n", integerBox.get());
        System.out.printf("String Value :%s\n", stringBox.get());


        // Generic method
        Double[] doubleArray = {1.1, 2.2, 3.3, 4.4};
        Character[] charArray = {'H', 'E', 'L', 'L', 'O'};
        printArray(doubleArray);
        printArray(charArray);


        // Generic class using parameterized type
        Trunk<Integer, List<String>> trunk = new Trunk<>();
        List<String> message = new ArrayList<>();
        message.add("Hi");
        message.add("Hey");
        message.add("Evening");

        trunk.add(20, message);
        System.out.println("Integer value: " + trunk.getFirst());
        System.out.println("List<String> value: " + trunk.getSecond());


        //Row
        Box rawBox;
        rawBox = integerBox; //No warning
        System.out.printf("Integer Value :%d\n", rawBox.get());


        //Warning for unchecked invocation to set(T)
        rawBox.add(10);
        System.out.printf("Integer Value :%d\n", rawBox.get());

        //Warning for unchecked conversion
        integerBox = rawBox;
        System.out.printf("Integer Value :%d\n", integerBox.get());

    }
}

//1. Generic class
class Box<T> {
    private T n;

    public void add(T n) {
        this.n = n;
    }

    public T get() {
        return n;
    }
}

//3. Generic Types:
/*
* E - Element (used extensively by java Collections Framework such as ArrayList)
* K - Key (Used in Map)
* V - Value
* N - Number
* T - Type
* S, U, V - 2nd, 3rd, 4th types
* */


//Generic class using Parameterized Types
class Trunk<T, S> {
    private T t;
    private S s;

    public void add(T t, S s) {
        this.t = t;
        this.s = s;
    }

    public T getFirst() {
        return t;
    }

    public S getSecond() {
        return s;
    }
}

class Animal {
}

class Cat extends Animal {
}

class RedCat extends Cat {
}

class Dog extends Animal {
}
