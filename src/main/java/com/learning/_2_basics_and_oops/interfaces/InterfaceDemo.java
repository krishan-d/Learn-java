package com.learning._2_basics_and_oops.interfaces;

interface I {
    void add();
    default void show() { System.out.println("I"); }

    //NOT POSSIBLE :
    //Note: Any method that override Object class methods can not be declared as default method.
    /*
    *  boolean equals(Object o) {}
    * */

    static void staticMethod() {
        System.out.println("static method !");
    }
}

interface K {
    default void show() { System.out.println("K"); }
}

class A {
    private void show() { System.out.println("A"); }
}

class  B{
    void show() { System.out.println("B"); }
}

class C {
    public void show() { System.out.println("C"); }
}

public class InterfaceDemo extends C implements I{

    public static void main(String[] args) {
        InterfaceDemo ob = new InterfaceDemo();
        ob.show();
        ob.add();

        //invoke static method...
        I.staticMethod();
    }

    @Override
    public void add() {
        System.out.println("Add method !");
    }
}
/*
class Example1 implements I {

    @Override
    public void add() {
        //...
    }
}

class Example2 implements I, K {

    @Override
    public void add() {
        //...
    }

    @Override
    public void show() {
        //...
    }
}

class Example3 extends A {
    //...
}
class Example4 extends B {
    //...
}
class Example5 extends A implements I {

    @Override
    public void add() {
        //...
    }
}

class Example6 extends B implements I {

    @Override
    public void add() {
        //...
    }

    @Override
    public void show() {
        //...
    }
}

class Example7 extends C implements I {

    @Override
    public void add() {
        //...
    }
}

class Example8 extends A implements I, K {

    @Override
    public void add() {
        //...
    }
}

class Example9 extends B implements I, K {

    @Override
    public void add() {
        //...
    }

    @Override
    public void show() {
        //...
    }
}
*/
