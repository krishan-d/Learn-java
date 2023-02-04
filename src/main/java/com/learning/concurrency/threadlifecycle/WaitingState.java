package com.learning.concurrency.threadlifecycle;

public class WaitingState implements Runnable{
    static Thread T;

    public static void main(String[] args) {
        T = new Thread(new WaitingState());
        T.start();
    }

    @Override
    public void run() {
        Thread thread = new Thread(new DemoThreadWS());
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }
    }
}
class DemoThreadWS implements Runnable {
    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }
        System.out.println(WaitingState.T.getState());
    }
}
