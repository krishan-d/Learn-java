package com.learning.concurrency.threadlifecycle;

public class RunnableState {
    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {

            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
        System.out.println(thread.getState());
    }
}
