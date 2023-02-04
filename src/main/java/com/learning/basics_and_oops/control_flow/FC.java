package com.learning.basics_and_oops.control_flow;

public class FC {
    public static void main(String[] args) {
        int number = 10;
        if (number < 0) System.out.print("Negative");

        /*
         * switch(expression) {
         * case v1:
         *     code
         *     break;
         *
         * case v2:
         *     code
         *     break;
         *
         * default:
         *     default code
         * }
         *
         * Note: switch statement works with:
         * Primitive data type: byte, short, char and int
         * Enumerated types
         * String Class
         * Wrapper Classes: Character, Byte, Short and Integer
         * */

        String size;
        switch (number) {
            case 10:
                size = "Ten";
                break;
            case 0:
                size = "Zero";
                break;
            default:
                size = "None";
                break;
        }
        System.out.print("\nSize: " + size + "\n"); // Ten

        switch (number) {
            case 10:
                size = "Ten";
            case 0:
                size = "Zero";
            default:
                size = "None";
        }
        System.out.print("\nSize: " + size + "\n"); // None

        //Enhanced switch:
        switch (number) {
            case 0 -> size = "Zero";
            case 1 -> size = "One";
            case 2 -> {
                size = "Two";
                System.out.println("This is case 2!");
            }
        }

        /*
         * Loops:
         * for (initialExpression; conditionExpression; updateExpression)
         *
         * for-each Loop
         * for (dataType item : array/List/Map/Set) {}
         *
         * while (conditionExpression) {}
         *
         * do {
         *     // body
         * } while (conditionExpression)
         *
         * */

        // break : used with decision-making statements

        Loop1:
        for (int i = 1; i <= 2; i++) {
            Loop2:
            for (int k = 0; k <= 1; k++) {
                if (i == 2) {
                    // break;  // break innermost Loop
                    break Loop1;
                }
                System.out.print("i=" + i + "k=" + k + "|");
            }
        }
        System.out.println();

        /*
         * continue : used with decision-making statements
         * skips current iteration of a Loop
         * */

        mainLoop:
        for (int i = 1; i <= 2; i++) {
            innerLoop:
            for (int k = 0; k <= 1; k++) {
                if (i == 1 || k == 1) {
                    // continue;  // continue skips current iteration of innermost Loop
                    continue innerLoop;
                }
                System.out.print("i=" + i + "k=" + k + "|");
            }
        }

    }
}
