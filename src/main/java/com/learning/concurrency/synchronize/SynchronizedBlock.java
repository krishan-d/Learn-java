package com.learning.concurrency.synchronize;

public class SynchronizedBlock {
    private int count = 0;
    private static int staticCount = 0;

    void performSynchronisedTask() {
        synchronized (this) {
            setCount(getCount() + 1);
        }
        /*
        Passed a parameter [this] to the synchronized block. This is monitor object.
        The code inside block gets synchronized on monitor object.
        Simply, only one thread per monitor object can execute inside that block of code.
        */
    }

    static void performStaticSyncTask() {
        synchronized (SynchronizedBlock.class) {
            setStaticCount(getStaticCount() + 1);
        }
        /*
        If method was static, pass Class name in place of object reference and the class would be a monitor.
        */
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public static int getStaticCount() {
        return staticCount;
    }

    public static void setStaticCount(int staticCount) {
        SynchronizedBlock.staticCount = staticCount;
    }

    public static void main(String[] args) {
        /*
        Synchronization:
        Need:
        1. In multithreaded environment, a race condition occurs when two or more threads attempt to
        update mutable shared data at the same time.
        2. To avoid race conditions.

        Race Condition:
        A condition of a program where its  behaviour depends on relative timing or
        interleaving of multiple threads or processes.

        Note: Synchronized block, allows only one thread at any given time.

        The Synchronized Keyword: can be used on different levels:
        1.Instance method:
            Instance method are synchronized over instance of the class owning method, which means
            only one thread per instance of the class can execute this method.

        2.Static method:
            These methods are synchronized on Class object associated with the class.
            Since only one Class object exists per JVM per class, only one thread can execute inside a
            static synchronized method per class, irrespective of number of instances it has.

        3.Code blocks:
            Sometimes we don't want to synchronize the entire method, only some instructions within it.
            We can achieve this by applying synchronized to a block:

        Reentrancy:
        The lock behind the synchronized methods and blocks is reentrant.
        This means the current thread can acquire the same synchronized block over and over again while holding it.
        */
    }
}
