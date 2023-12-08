package com.learning.basics_and_collections.generics;

import java.util.ArrayList;
import java.util.List;

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
