package com.learning.basics_and_oops.inner_class;

class Outer_Class2 {

    void my_method() {
        int num = 20;

        class Method_Inner_Demo {
            public void print() {
                System.out.println("This is method inner class " + num);
            }
        }

        Method_Inner_Demo inner = new Method_Inner_Demo();
        inner.print();
    }
}

public class Code3_MethodLocal_InnerClass {

    public static void main(String[] args) {

        Outer_Class2 outer = new Outer_Class2();
        outer.my_method();
    }
}
