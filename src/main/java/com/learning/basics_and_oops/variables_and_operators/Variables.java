package com.learning.basics_and_oops.variables_and_operators;

public class Variables {

    int data = 20; //instance variable
    static int n = 100; //static variable

    void method() { int m = 40; /*local variable */ }

    public static void main(String[] args) {
        //variable widening i.e. Type promotion
        int i = 10;
        float f = i;
        System.out.println(i);
        System.out.println(f);

        //variable narrowing i.e Type casting
        float f1 = 10.4F;
        //int i1 = f1; // CTE
        int i1 = (int) f1;
        System.out.println(i1);

        //value overflowing
        int i2 = 130;
        byte b1 = (byte) i2;
        System.out.println(b1);

        //operations on lower Types like byte or short
        byte b2 = 10;
        byte b3 = 20;
        //byte c = b2 + b3; //Compile Time Error
        byte c = (byte) (b2 + b3);

    }

}
