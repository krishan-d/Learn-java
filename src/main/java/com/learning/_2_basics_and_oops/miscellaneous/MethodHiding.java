package com.learning._2_basics_and_oops.miscellaneous;

public class MethodHiding extends A {
    public static void main(String[] args) {
        MethodHiding.method();
    }
    private static void method() {
        System.out.println("B");
    }

}

class A {
    private static void method() {
        System.out.println("A");
    }
}
