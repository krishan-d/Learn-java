package com.learning.concurrency;

class NewTread extends Thread {
    private String threadName;
    public NewTread(String name) {
        threadName = name;
        System.out.println("Creating " + threadName);
    }

    public void run() {
        System.out.println("Running " + this.getName());
        try {
            for (int i =4; i > 0; i--) {
                System.out.println("Thread: " + this.getName() + ", " + i);
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("Thread" + this.getName() + " interrupted.");
        }
        System.out.println("Thread " + this.getName() + " exiting.");
    }
}
public class ThreadClassDemo extends Thread {

    public static void main(String[] args) {
        NewTread T1 = new NewTread("Thread-1");
        T1.start();

        NewTread T2 = new NewTread("Thread-2");
        T2.start();
    }
}
