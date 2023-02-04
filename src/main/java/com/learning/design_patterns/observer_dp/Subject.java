package com.learning.design_patterns.observer_dp;

public interface Subject {
    void subscribe(Subscriber subscriber);

    void unSubscriber(Subscriber subscriber);

    void notifySubscriber();

    void upload(String title);
}
