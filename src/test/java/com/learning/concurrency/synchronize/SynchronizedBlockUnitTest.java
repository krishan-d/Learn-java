package com.learning.concurrency.synchronize;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

import static org.junit.Assert.assertEquals;

public class SynchronizedBlockUnitTest {

    @Test
    public void givenMultiThread_whenBlockSync() throws InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(3);
        SynchronizedBlock synchronizedBlocks = new SynchronizedBlock();

        IntStream.range(0, 1000)
                .forEach(count -> service.submit(synchronizedBlocks::performSynchronisedTask));
        service.awaitTermination(500, TimeUnit.MILLISECONDS);

        assertEquals(1000, synchronizedBlocks.getCount());
    }

    @Test
    public void givenMultiThread_whenStaticSyncBlock() throws InterruptedException {
        ExecutorService service = Executors.newCachedThreadPool();

        IntStream.range(0, 1000)
                .forEach(count -> service.submit(SynchronizedBlock::performStaticSyncTask));
        service.awaitTermination(500, TimeUnit.MILLISECONDS);

        assertEquals(1000, SynchronizedBlock.getStaticCount());
    }

    @Test
    public void givenHoldingTheLock_whenReentrant_thenCanAcquireItAgain() {
        Object lock = new Object();
        synchronized (lock) {
            System.out.println("First time acquiring it");

            synchronized (lock) {
                System.out.println("Entering again");

                synchronized (lock) {
                    System.out.println("And again");
                }
            }
        }
    }
}
