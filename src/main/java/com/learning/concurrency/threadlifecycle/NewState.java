package com.learning.concurrency.threadlifecycle;

public class NewState {
    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread running...");
            }
        };

        Thread T = new Thread(runnable);
        System.out.println("Thread : " + T.getState());
    }
}
