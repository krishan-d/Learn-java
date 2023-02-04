package com.learning.concurrency.threadlifecycle;

public class TimedWaitingState {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new DemoThread());
        thread.start();

        Thread.sleep(1000);
        System.out.println(thread.getState());
    }
}

class DemoThread implements Runnable {

    @Override
    public void run() {
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }
    }
}
