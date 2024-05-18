package com.learning._1_basics.mine;

interface Printable {
    void print();

    default void msg() {
        System.out.println("default method with body!");
    }

    static int cube(int x) {
        return x * x * x;
    }
}

interface ShowAble {
    void show();

    void print();
}

public class Testing1 implements ShowAble, Printable {

    @Override
    public void print() {
        System.out.println("printing...");
    }

    @Override
    public void show() {
        System.out.println("showing...");

    }

    public static void main(String[] args) {
        Testing1 obj = new Testing1();
        obj.print();
        obj.show();
        obj.msg();
        System.out.println(Printable.cube(3));

    }
}
