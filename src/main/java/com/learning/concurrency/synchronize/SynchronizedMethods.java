package com.learning.concurrency.synchronize;

public class SynchronizedMethods {
    private int sum = 0;
    private int syncSum = 0;
    static int staticSum = 0;

    void calculate() {
        setSum(getSum() + 1);
    } //might produce race condition
    synchronized void synchronisedCalculate() {
        setSyncSum(getSyncSum() + 1);
    } //To handle race condition

    static synchronized void syncStaticCalculate() {
        staticSum = staticSum + 1;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public int getSyncSum() {
        return syncSum;
    }

    public void setSyncSum(int syncSum) {
        this.syncSum = syncSum;
    }
}
