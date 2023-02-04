package com.learning.misc_advanced.lambda;

public class LambdaExpressionExample2 {
    public static void main(String[] args) {
        //Thread without Lambda
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread1 is running ...");
            }
        };
        Thread thread1 = new Thread(r1);
        thread1.start();

        //Thread with lambda
        Runnable r2 = () -> System.out.println("Thread2 is running ...");
        Thread thread2 = new Thread(r2);
        thread2.start();
    }
}
