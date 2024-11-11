package com.learning.dp.behavioral.b_observer;

public interface Observer {
    void update();

    void subscribeChannel(Channel ch);
}
