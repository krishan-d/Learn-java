package com.learning.concurrency.lock;

public class ObjectLevelLock implements Runnable{
    public void run() { Lock(); }
    public void Lock()
    {
        /**
         * Every object in java has a unique lock. Whenever we are using a synchronized keyword, then only the lock concept will come into the picture.
         * If a thread wants to execute then synchronized method on the given object. First, it has to get a lock-in that object.
         * Once the thread got the lock then it is allowed to execute any synchronized method on that object.
         * Once method execution completes automatically thread releases the lock.
         */
        System.out.println(Thread.currentThread().getName());
        synchronized (this) {
            System.out.println("in block " + Thread.currentThread().getName());
            System.out.println("in block " + Thread.currentThread().getName() + " end");
        }
    }

    public static void main(String[] args)
    {
        ObjectLevelLock g = new ObjectLevelLock();
        Thread t1 = new Thread(g);
        Thread t2 = new Thread(g);
        ObjectLevelLock g1 = new ObjectLevelLock();
        Thread t3 = new Thread(g1);
        t1.setName("t1");
        t2.setName("t2");
        t3.setName("t3");
        t1.start();
        t2.start();
        t3.start();
    }
}
