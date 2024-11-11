package com.learning.dp.behavioral.b_observer;

import java.util.ArrayList;
import java.util.List;

public class Channel implements Subject {

    private String chName;
    List<Subscriber> subscribers = new ArrayList<>();
    private String title;

    public Channel(String chName) {
        this.chName = chName;
    }

    public String getChName() {
        return chName;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public void subscribe(Subscriber subscriber) {
        subscribers.add(subscriber);
    }

    @Override
    public void unSubscriber(Subscriber subscriber) {
        subscribers.remove(subscriber);
    }

    @Override
    public void notifySubscriber() {
        for (Subscriber sub : subscribers) {
            sub.update();
        }
    }

    @Override
    public void upload(String title) {
        this.title = title;
        notifySubscriber();
    }

}
