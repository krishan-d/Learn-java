package com.learning.basics_and_collections.generics;

import java.util.ArrayList;

class Container<T extends Number> {
    T value;

    public Container(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public void show() {
        System.out.println(value.getClass().getName());
    }

    public void demo(ArrayList<? extends Number> ob) {
        System.out.println("sub-class");
    }

    public void superWcDemo(ArrayList<? super Integer> ob) {
        System.out.println("super");
    }
}
public class GenericExample {

    public static void main(String[] args) {
        Container<Integer> container = new Container<>(10);
        container.show();

        container.demo(new ArrayList<Integer>());
        container.demo(new ArrayList<Number>());
        container.demo(new ArrayList<Double>());

        container.superWcDemo(new ArrayList<>());
        container.superWcDemo(new ArrayList<Number>());
//      container.superWcDemo(new ArrayList<Double>()); // CTE
    }
}
