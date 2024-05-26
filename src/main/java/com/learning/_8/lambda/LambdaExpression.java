package com.learning._8.lambda;

@FunctionalInterface
interface FuncInter1 {
    int i = 10;

    //Abstract Function
    void abstractFun(int x);
    //Non-abstract (or default) Function
    default void normalFunc() {
        System.out.println("This is normal function!");
    }

    //Non-abstract static method
    static void staticFunc() {
        System.out.println("This is a static method inside Functional Interface");
    }
}

interface FuncInter2 {
    int operation(int a, int b);
}

interface FuncInter3 {
    void sayMessage(String message);
}

interface FuncInter4{
    String  method1();

    // NOTE: on uncommenting, this interface is no longer Functional interface, and lambda will no longer work
//  String method2();
}

public class LambdaExpression {
    /*
     * lambda Expression:
     * To provide implementation of Functional interface | Less coding
     * or
     * To represent an anonymous [nameless | unknown] function
     *
     * Functional interface:
     * Has only one abstract method and @FunctionalInterface annotation is used to declare interface as Functional interface
     * Ex. Runnable --> run()
     * Callable --> call()
     * Comparable --> compareTo()
     * Comparator --> compare()
     *
     * Syntax:
     * () -> expression
     * (param...) -> { body }
     * */

    private int operate(int a, int b, FuncInter2 ob) {
        return ob.operation(a, b);
    }

    public static void main(String[] args) {

        //Functional Interface
        FuncInter1 f1 = x -> System.out.println(2 * x);
        f1.abstractFun(20); // 40
        f1.normalFunc();
        FuncInter1.staticFunc();

        LambdaExpression obj = new LambdaExpression();
        FuncInter2 add = Integer::sum;
        FuncInter2 divide = (x, y) -> x / y;
        //Or
        /*
        FuncInter2 d = new FuncInter2() {
            @Override
            public int operation(int a, int b) {
                return a / b;
            }
        };*/
        System.out.println(add.operation(1, 7));
        System.out.println("Addition is: " + obj.operate(10, 2, add)); // 12
        System.out.println("Division is: " + obj.operate(10, 2, divide)); // 5

        FuncInter3 f3 = message -> System.out.println("Hi, " + message + "!");
        f3.sayMessage("Edwina");

        FuncInter4 f4 = ()-> {return "String F4";};
        System.out.println(f4.method1());

    }
}
