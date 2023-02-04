package com.learning.design_patterns.observer_dp;

public interface Observer {
    void update();

    void subscribeChannel(Channel ch);
}
