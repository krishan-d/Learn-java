package com.learning.concurrency.executorservice;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ExecutorServiceDemo {

    /*
    * ExecutorService:
    * The ExecutorService implements the Thread Pool design pattern (also called a replicated worker or worker-crew model)
    * Adds some very useful features like thread re-usability and task queues.
    * Takes care of thread management.
    *
    * */
    ExecutorService executorService = Executors.newFixedThreadPool(10); //Thread pool of 10 Threads

    public void execute() {
        executorService.submit(Task::new);

        executorService.shutdown();
        List<Runnable> list = executorService.shutdownNow();

        try {
            if (!executorService.awaitTermination(201, TimeUnit.NANOSECONDS)) executorService.shutdownNow();

        } catch (InterruptedException e) {
            e.printStackTrace();
            executorService.shutdownNow();
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //Factory Methods of Executors Class
        ExecutorService executor = Executors.newFixedThreadPool(10);

        //Directly create an ExecutorService
        LinkedBlockingQueue<Runnable> blockingQueue = new LinkedBlockingQueue<>();
        ExecutorService executorService1;
        executorService1 = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, blockingQueue);

        //Assigning Task to the ExecutorService:
        //Note: ExecutorService can execute Runnable and Callable Tasks.
        Runnable runnableTask = () -> {
            try {
                TimeUnit.MILLISECONDS.sleep(300);
                System.out.println("Runnable Task's execution !");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        Callable<String> callableTask = () -> {
            TimeUnit.MILLISECONDS.sleep(300);
            return "Callable Task's execution!";
        };

        List<Callable<String>> callablesTasks = new ArrayList<>();
        callablesTasks.add(callableTask);
        callablesTasks.add(callableTask);
        callablesTasks.add(callableTask);

        //We can assign tasks to the ExecutorService using several methods including execute(), submit(), invokeAny() and invokeAll().
        //execute():
        //doesn't give any possibility to get the result of a task's execution or to check task's status.
        executorService1.execute(runnableTask);

        //submit():
        //submits a Callable or a Runnable task to an ExecutorService and return a result of type Future.
        Future<String> future = executorService1.submit(callableTask);
        System.out.println("future = " + future);

        //invokeAny():
        //assign collection of tasks to an ExecutorService, causing each to run and returns the result of a successful
        //execution of one task(if there was a successful execution)
        String result = executorService1.invokeAny(callablesTasks);
        System.out.println("invokeAny result: " + result);

        //invokeAll():
        //assign a collection of tasks to an ExecuteService, causing each to run and return the result of
        //all task execution in the form of a list of objects of type Future.
        List<Future<String>> futureList = executorService1.invokeAll(callablesTasks);
        System.out.println("invokeAll List: " + futureList);


        //Shutting Down an ExecutorService
        //shutdown():
        //doesn't cause immediate destruction of the ExecutorService.
        //It will make the ExecutorService stop accepting new tasks and shut down after all running threads finish their current work.
        System.out.println("executorService1.isShutdown() = " + executorService1.isShutdown());
        executorService1.shutdown();

        System.out.println("executorService1.isShutdown() = " + executorService1.isShutdown());
        System.out.println("executorService1.isTerminated() = " + executorService1.isTerminated());

        //OR
        //shutdownNow():
        //destroy the ExecutorService immediately, but it doesn't guarantee that all the running threads will be stopped at the same time.
        //returns a list of tasks that are waiting to be processed
        List<Runnable> list = executorService1.shutdownNow();
        System.out.println("shutdownNow: " + list);

        //OR
        //awaitTermination():
        //will first stop taking new tasks and then wait up to a specified period of time for all tasks to be completed.
        //If that time expires, the execution is stopped immediately and return false.
        try {
            if (!executorService1.awaitTermination(201, TimeUnit.NANOSECONDS)) executorService1.shutdownNow();

        } catch (InterruptedException e) {
            e.printStackTrace();
            executorService1.shutdownNow();
        }


        //Future Interface:
        String res = null;
        try {
            //res = future.get();
            //OR
            res = future.get(200, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            e.printStackTrace();
        }
        System.out.println("res: " + res);


    }
}
