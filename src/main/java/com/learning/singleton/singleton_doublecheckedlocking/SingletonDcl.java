package com.learning.singleton.singleton_doublecheckedlocking;

public class SingletonDcl {

    public static void main(String[] args) {
        System.out.println("Current Thread: " + Thread.currentThread().getName()); //main

        Thread T1 = new Thread(() -> {
            Abc ob1 = Abc.getInstance();
        });

        Thread T2 = new Thread(() -> {
            Abc ob2 = Abc.getInstance();
        });

        T1.start();
        //T1.start(); //will throw IllegalThreadStateException i.e. start method can be invoked only once one a Thread
        T2.start();
    }
}

class Abc {
    public static Abc ob; //declaration
    private Abc() {
        System.out.println("Private constructor created!");
    }

    public static Abc getInstance() { //Double-Checked Locking
        //object instantiation
        if (ob == null) {
            synchronized(Abc.class) { // makes 6x times slower
                if (ob == null) ob = new Abc();
            }
        }
        return ob;
    }

}
