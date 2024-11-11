package com.learning.dp.creational.c_singleton.singleton_enum_instance;

/**
 * SINGLETON DESIGN PATTERN USING ENUM INSTANCE
 * */
public class SingletonEnum {

    public static void main(String[] args) {
        Abc ob1 = Abc.INSTANCE;
        ob1.i = 10;
        ob1.show(); //10

        Abc ob2 = Abc.INSTANCE;
        ob2.i = 20;

        ob1.show(); //20  //Why? : enum uses current instance.
    }
}
//Note: enum is the best way to define singleton class

enum Abc { //Special Type of class
    INSTANCE; //Creates a private constructor class implicitly
    int i;
    public void show() {
        System.out.println(i);
    }

    /*
    * Advantage:
    *
    * While working with deserialization. Even if my class is Singleton, readObject() method will give new Object.
    * That's why using enum gives readResolve() method. readResolve() will not create new object i.e. it uses current object/ instance.
    * */
}
