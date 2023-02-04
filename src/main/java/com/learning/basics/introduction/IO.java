package com.learning.basics.introduction;

import java.util.Scanner;

public class IO {

    public static void main(String[] args) {
        // Command Line Input
        //

        // Output
        String name = "Eve";
        System.out.print("Hi There" + "! " + name);

        // Input
        Scanner sc = new Scanner(System.in);  // Scanner object
        int number = sc.nextInt();  // Taking input
        System.out.print("In: " + number);

        double d = sc.nextDouble();
        System.out.print("Double: " + d);

        // scanner object closing
        sc.close();
    }
}
