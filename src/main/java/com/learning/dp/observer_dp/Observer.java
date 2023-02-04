package com.learning.dp.observer_dp;

public interface Observer {
    void update();

    void subscribeChannel(Channel ch);
}
