package com.learning.concurrency.scheduledexecutorservice;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

public class ScheduledExecutorServiceDemo {

    private void execute() {
        //ScheduledExecutorService with one Thread
        ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
        getTasksToRun().apply(executorService);
        executorService.shutdown();
    }

    private void executeWithMultiThread() {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(2);
        getTasksToRun().apply(executorService);
        executorService.shutdown();
    }

    private Function<ScheduledExecutorService, Void> getTasksToRun() {
        return (executorService -> {
            //schedule():
            //Allows to execute Runnable or Callable Tasks.
            ScheduledFuture<?> scheduledFuture1 = executorService.schedule(() -> {
                //callableTask
            }, 1, TimeUnit.SECONDS); //1-second delay before executing callableTask.

            //scheduleAtFixedRate():
            //If the processor needs more time to run an assigned task than the period parameter of the
            //scheduleAtFixedRate() method, the ScheduledExecutorService will wait until the current task is completed
            //before starting the next.

            ScheduledFuture<?> scheduledFuture2 = executorService.scheduleAtFixedRate(() -> {
                //Task
            }, 1, 10, TimeUnit.SECONDS);

            //scheduleWithFixedDelay():
            //To have a fixed length delay between iterations of the task.
            ScheduledFuture<?> scheduledFuture3 = executorService.scheduleWithFixedDelay(() -> {
                //Task
            }, 1, 10, TimeUnit.SECONDS);

            ScheduledFuture<?> scheduledFuture4 = executorService.schedule(() -> {
               //Task
               return "Hello world";
            }, 1, TimeUnit.SECONDS);

            return null;
        });
    }

    public static void main(String[] args) {

        /*
        ScheduledExecutorService Interface:
        Runs tasks after some predefined delay or periodically.

        Pros over Timer:
        1.Can be configured with any number of threads
        2.Can take advantage of all available CPU cores
        3.Catches Runtime Exceptions and lets us handle them if we want to.
        4.Cancels the task that threw the Exception, while letting others continue to run.
        5.Relies on OS Scheduling system to keep track of Time zones, delays...
        6.Provides collaborative API if we need coordination between multiple tasks, like waiting for the
        completion of all tasks submitted.
        7.Provides better API for management of Thread life-cycle, than Timer.

        */
        ScheduledExecutorServiceDemo demo = new ScheduledExecutorServiceDemo();
        demo.execute();
        demo.executeWithMultiThread();

    }
}
