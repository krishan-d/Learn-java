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

public class LambdaExpression {
    /*
     * lambda Expression:
     * To provide implementation of Functional interface
     * Less coding
     *
     * Functional interface:
     * Has only one abstract method and @FunctionalInterface annotation is used to declare interface as Functional interface
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
        FuncInter1 ob = x -> System.out.println(2 * x);
        ob.abstractFun(10);
        ob.normalFunc();
        FuncInter1.staticFunc();

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

        LambdaExpression le = new LambdaExpression();
        System.out.println("Addition is: " + le.operate(10, 2, add));
        System.out.println("Division is: " + le.operate(10, 2, divide));


        FuncInter3 ob1 = message -> System.out.println("Hi, " + message + "!");
        ob1.sayMessage("Edwina");

    }
}
