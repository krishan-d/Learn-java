package com.learning.basicsl_and_oops.inner_class;

class Outer_Demo {

    private class Inner_Demo {
        public void print() { System.out.println("Inner class"); }
    }

    void display_inner() {
        Inner_Demo inner = new Inner_Demo();
        inner.print();
    }
}

public class Code1_BasicInnerClass {

    public static void main(String[] args) {
        Outer_Demo outer = new Outer_Demo();
        outer.display_inner();
    }
}
