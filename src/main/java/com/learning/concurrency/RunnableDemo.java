package com.learning.concurrency;

public class RunnableDemo implements Runnable{
    @Override
    public void run() {
        System.out.println("Thread is running...");
        try {
            for (int i = 4; i > 0; i--) {
                System.out.println("Thread: " + i);
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Thread exiting...");
    }

    public static void main(String[] args) {
        RunnableDemo r1 = new RunnableDemo();
        Thread t1 = new Thread(r1, "Thread-1");
        t1.start();

        RunnableDemo r2 = new RunnableDemo();
        Thread t2 = new Thread(r2, "Thread-2");
        t2.start();
    }
}
