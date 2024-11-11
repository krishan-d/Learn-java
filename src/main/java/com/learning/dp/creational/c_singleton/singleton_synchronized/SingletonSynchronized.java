package com.learning.dp.creational.c_singleton.singleton_synchronized;

/**
* SINGLETON DESIGN PATTERN SYNCHRONIZED GETINSTANCE()
* */
public class SingletonSynchronized {

    public static void main(String[] args) {
        //ABC o1 = new ABC(); //CTE

        System.out.println("Current Thread: " + Thread.currentThread().getName()); //main

        Thread T1 = new Thread(() -> {
            Abc ob1 = Abc.getInstance();
        });

        Thread T2 = new Thread(() -> {
            Abc ob2 = Abc.getInstance();
        });

        T1.start();
        T2.start();
    }
}

class Abc {

    public static Abc ob; //declaration
    private Abc() {
        System.out.println("Private constructor created!");
    }

    public static synchronized Abc getInstance() { //makes 100 * x times slower
        //object instantiation
        if (ob == null) ob = new Abc();
        return ob;
    }
    /*
    * problem with synchronized:
    * when getInstance method has a lot of work that needs to be done then synchronized block will reduce the
    * performance by 100X.
    *
    * Solution:
    * Double-Checked Locking
    * */

}
