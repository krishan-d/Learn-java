package com.learning.concurrency.scheduledexecutorservice;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TimerDemo {
    public static void main(String[] args) {

        /*
        Timer:
        To schedule task for future execution in background thread.
        Tasks may be scheduled for one-time execution or repeated execution at regular intervals.

        1.Does not offer real-time guarantees. It schedules tasks using Object.wait(long) method.
        2.There is a single background thread, so tasks run sequentially and long-running task can delay others.
        3.Runtime exception thrown in a TimerTask would kill the only thread available, thus kill Timer.

        */
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                System.out.println("Task performed on: " + new Date() + "\n" +
                        "Thread name: " + Thread.currentThread().getName());
            }
        };

        Timer timer = new Timer("Timer-1");
        long delay = 1000L;

        timer.schedule(task, delay); //Run task after 1 second of delay

        //Adding a recurring schedule
        //timer.scheduleAtFixedRate(task, delay, 10);
    }
}
