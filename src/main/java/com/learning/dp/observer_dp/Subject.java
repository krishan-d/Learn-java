package com.learning.dp.observer_dp;

public interface Subject {
    void subscribe(Subscriber subscriber);

    void unSubscriber(Subscriber subscriber);

    void notifySubscriber();

    void upload(String title);
}
