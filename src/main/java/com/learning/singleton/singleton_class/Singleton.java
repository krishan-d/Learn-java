package com.learning.singleton.singleton_class;

public class Singleton {

    public static void main(String[] args) {
        //ABC o1 = new ABC(); //CTE

        ABC o1 = ABC.getInstance();
        ABC o2 = ABC.getInstance(); //Every time we will get same instance from ABC class
    }
}

class ABC {
    /*
    * Singleton:
    * Making class singleton means only one instance/object can be created of that class.
    *
    * To make a class singleton, these 3 steps are followed.
    * */

    //1. create static object inside class

    // Eagerly instantiation:
    public static ABC o = new ABC();

    /*
    problem:
    Above object is static i.e. This static object will be created and will be on memory when the class is loaded.
    And it becomes a global variable.
    Even when this object is not being used, it will be in memory.
    This will consume more memory and decrease performance.
    */

    //2. make private constructor
    private ABC() {
        System.out.println("Private constructor !");
    }

    //3. make a static method to return the object created in step 1.
    public static ABC getInstance() {
        return o;
    }

}

