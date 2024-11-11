package com.learning.dp.behavioral.b_observer;

public class Subscriber implements Observer {

    private String name;
    private Channel channel;

    public Subscriber(String name) {
        this.name = name;
    }

    @Override
    public void update() {
        System.out.println("Hey " + name + ", new video : " + channel.getTitle() + ", is uploaded on : " + channel.getChName());
    }

    @Override
    public void subscribeChannel(Channel ch) {
        channel = ch;
    }
}
