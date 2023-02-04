package com.learning.functionalprogramming.techniques;

import java.util.stream.LongStream;

public class FPRecursion {
    /*
    Recursion:
    Downside: slower compared to an iterative approach and might result in stack overflow error since
    function call needs to be saved as a frame to the stack.
    To avoid this Tail recursion is preferred, specially when the recursion is done too many times.

    Tail recursion:
    recursive call is the last thing executed by the function and hence the function stack need not be saved by compiler.

    */

    //Traditional Iterative approach
    //benchmark 9.645 ns/op
    static long factorial(long num) {
        long result = 1;
        for(; num > 0 ; num--) result *= num;
        return result;
    }

    //Using Recursion
    //benchmark 19.567 ns/op
    static long factorialRec(long num) {
        return num == 1 ? 1 : num * factorial(num - 1);
    }

    //benchmark 16.701 ns/op
    static long factorialTailRec(long num) {
        return factorial(1, num);
    }

    static long factorial(long accumulator, long val) {
        return val == 1 ? accumulator : factorial(accumulator * val, val - 1) ;
    }

    //benchmark 59.565 ns/op
    static long factorialStream(long num) {
        return LongStream.rangeClosed(1, num).reduce(1, (n1, n2) -> n1 * n2);
    }

    public static void main(String[] args) {
        System.out.println(factorial(5));

        System.out.println(factorialRec(5));

        System.out.println(factorialTailRec(5));
    }
}
