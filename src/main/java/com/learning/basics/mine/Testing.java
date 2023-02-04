package com.learning.basics.mine;

interface Message {
    String greet();

    default void methodWithBody() {
        System.out.println("Method with body inside interface must be default and static!");
    }
}

abstract class AnonymousClass {
    abstract void anonymous_method();
}

class B {
    int num;
    private int m = 10;
    static int count = 0;  //will get memory only once and retain its value

    //int count = 0;
    //static block : To initialize static members and compiled before main method
    static {
        System.out.println("static block is invoked");
    }

    //constructor
    B() {
        count++;
        System.out.println(count);
    }

    //instance method
    void show() {
        System.out.println(num);
    }

    //static instance method
    static int cube(int x) {
        return x * x * x;
    }

    //non-static instance method
    int cube1(int x) {
        return x * x * x;
    }

    //inner class
    class Inner_Class {
        //instance method inner class
        public int get_m() {
            System.out.println("Inner class method!");
            return m;
        }
    }

    //private inner class
    private static class Inner_Class_Private {
        public void print() {
            System.out.println("Inner class private!");
        }
    }

    void display_inner() {
        Inner_Class_Private innerPri = new Inner_Class_Private();
        innerPri.print();
    }

    //instance method outer class
    void my_method() {
        int num = 20;
        //method inner local class
        class Method_InnerClass {
            public void print() {
                System.out.println("Method inner local class: " + num);
            }
        }

        Method_InnerClass innerObj = new Method_InnerClass();
        innerObj.print();
    }

    //Anonymous interface
    void displayMessage(Message m) {
        System.out.println(m.greet() + " Anonymous inner class as an argument!");
    }
}

public class Testing {
    public static void main(String args[]) {

        //Testing test_obj = new Testing();


        /*
        int number = 20;
        switch (number) {
            case 10:
                System.out.println("10");
            case 20:
                System.out.println("20");
            case 30:
                System.out.println("30");
            default:
                System.out.println("Not in 10, 20 or 30");
        }
        */
        B outerObj = new B();
        /*
        outerObj.show();

        outerObj.num = 4;
        System.out.println(a.num);
        B b = new B();
        B c = new B();
        */

        System.out.println(B.cube(3));
        System.out.println(B.count);

        //Accessing static method
        System.out.println(outerObj.cube1(3));

        // Instantiating inner class
        B.Inner_Class inner = outerObj.new Inner_Class();
        System.out.println(inner.get_m());

        //Private inner class
        outerObj.display_inner();

        //method local inner class
        outerObj.my_method();

        //Anonymous inner class as an argument
        outerObj.displayMessage(() -> "Hi!");


        Message mm = () -> "Bye!";
        mm.greet();
        mm.methodWithBody();


        AnonymousClass anonymousObj = new AnonymousClass() {
            @Override
            void anonymous_method() {
                System.out.println("Anonymous inner class example!");
            }
        };
        anonymousObj.anonymous_method();

    }
}
