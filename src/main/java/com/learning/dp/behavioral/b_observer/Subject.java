package com.learning.dp.behavioral.b_observer;

public interface Subject {
    void subscribe(Subscriber subscriber);

    void unSubscriber(Subscriber subscriber);

    void notifySubscriber();

    void upload(String title);
}
