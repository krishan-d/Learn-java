package com.learning.concurrency.waitandnotify;

public class Data {

    /*
    Thread Synchronization:
    In multithreaded environment, multiple threads might try to modify the same resource.

    Guarded Blocks:
        Guarded blocks keep a check for a particular condition before resuming execution.
        1.Object.wait(): To suspend a Thread
        2.Object.notify(): To wake a Thread up

    Wait() method:
        Forces the current thread to wait until some other thread invokes notify() or notifyAll()
        on the same object.
        For this current thread must own object's monitor. This can happen in ways:
        1.when we've executed synchronized instance method for the given object.
        2.when we've executed the body of a synchronized block on the given object.
        3.by executing synchronized static methods for objects of type Class.

        wait():
        Cause current thread to wait indefinitely until another thread invokes notify() for this object.

        wait(long timeout):
        Specify a timeout after which, a thread will be woken up automatically.
        Thread can be woken up before reaching timeout using notify() and notifyAll().

        wait(long timeout, int nanos):
        Total timeout period(in nanoseconds) is calculated as 1_000_000*timeout + nanos.
        Provide higher precision.

    notify():
    Notifies any one of them to wake up arbitrarily.
    The choice of exactly which thread to wake is nondeterministic and depends upon the implementation.

    notifyAll():
    Wakes all threads that are waiting on this object's monitor.
    The awakened threads will complete in the usual manner, like any other thread.

    */

    /*
    * Sender-Receiver Problem
    * 1.The Sender is supposed to send a data packet to the Receiver.
    * 2.The Receiver cannot process the data packet until the Sender finishes sending it.
    * 3.Similarly, the Sender shouldn't attempt to send another packet unless the Receiver has already processed the
    * previous packet.
    * */
    private String packet;

    // True if receiver should wait for sender to send message
    // False if sender should wait for receiver to receive the message
    private boolean transfer = true;

    /*
    Why we need synchronized send() and receive() methods?
    --  To provide intrinsic locks. If a thread calling wait() method does not own inherent lock,
    an error will be thrown.
    */
    public synchronized String receive() {
        /*
        1.If transfer was set to false by Sender, only then it will proceed otherwise call wait() on this thread.
        2.When condition is met, we toggle the status, notifyAll() waiting threads to wake up, and return data packet
        that was received.
        */

        /*
        Why enclose wait() in while loop?
        --  Since notify() and notifyAll() randomly wake up threads that are waiting on this object's monitor.
        It's not always important that the condition is met. Sometimes the thread is woken up but the condition isn't
        actually satisfied yet.
        */
        while (transfer) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Thread Interrupted");
            }
        }
        transfer = true;

        String returnPacket = packet;
        notifyAll();
        return returnPacket;
    }

    public synchronized void send(String packet) {
        /*
        1.If transfer is false, we will wait by calling wait() on this thread.
        2.if transfer is true, we toggle the status, set our message and call notifyAll() to wake up threads to
        specify that a significant event has occurred and check if they can continue execution.
        */
        while (!transfer) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Thread Interrupted");
            }
        }
        transfer = false;

        this.packet = packet;
        notifyAll();
    }

    public static void main(String[] args) {
        boolean b = true;

        if (b) System.out.println("b: " + b);
        if (!b) System.out.println("!b: " + b);
    }
}
