package com.learning._1_basics.introduction;

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
        System.out.println("In: " + number);

        double d = sc.nextDouble();
        System.out.println("Double: " + d);

        // scanner object closing
        sc.close();

        String m = """
                {
                    "id" : 100,
                    "amount" : 1234.67
                }
                """;
        System.out.println(m);


        /**
         * NOTE:
         * System.out.println() is used to print the message on the console. System - It is a class present in java.lang package.
         * Out is the static variable of type PrintStream class present in the System class.
         * println() is the method present in the PrintStream class.
         */
    }
}
