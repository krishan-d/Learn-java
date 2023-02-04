package com.learning.dp.singleton.singleton_lazy_instance;

public class SingletonLazy {

    public static void main(String[] args) {
        //ABC o1 = new ABC(); //CTE

        System.out.println("Current Thread: " + Thread.currentThread().getName()); //main
        Lazy l1 = Lazy.getInstance();
        Lazy l2 = Lazy.getInstance();

        /*
        * problem:
        *
        * Lazy instantiation does not work in multithreaded environment. because multiple threads might create
        * new instance of the class.
        *
        * Solution: Synchronized getInstance()
        * */
    }

}

class Lazy {

    /*
    Lazy Instantiation:
    In lazy instantiation object is created when its required or needed.
    */
    public static Lazy ob; //declaration
    private Lazy () {
        System.out.println("Private constructor created!");
    }

    public static Lazy getInstance() {
        //object creation/instantiation
        if (ob == null) ob = new Lazy();
        return ob;
    }

}
