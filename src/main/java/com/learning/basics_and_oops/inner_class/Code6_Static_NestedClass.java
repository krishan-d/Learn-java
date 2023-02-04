package com.learning.basics_and_oops.inner_class;

public class Code6_Static_NestedClass {

    static class Nested_Demo {
        public void my_method() {
            System.out.println("This is nested class!");
        }
    }

    public static void main(String[] args) {

        Code6_Static_NestedClass.Nested_Demo nested = new Code6_Static_NestedClass.Nested_Demo();
        nested.my_method();
    }
}
