package com.learning.dp.behavioral.b_observer;

//Observer Design Pattern
public class YouTube {

    public static void main(String[] args) {
        Channel channel = new Channel("Code Here");

        Subscriber s1 = new Subscriber("s1");
        Subscriber s2 = new Subscriber("s2");
        Subscriber s3 = new Subscriber("s3");
        Subscriber s4 = new Subscriber("s4");

        channel.subscribe(s1);
        channel.subscribe(s2);
        channel.subscribe(s3);
        channel.subscribe(s4);

        s1.subscribeChannel(channel);
        s2.subscribeChannel(channel);
        s3.subscribeChannel(channel);
        s4.subscribeChannel(channel);

        channel.unSubscriber(s3);

        channel.upload("How To Learn DB");

        /*
        * In this case, all the subscribers are observer, observing the subject (channel in this case)
        * Every time a video is uploaded subscriber gets a notification.
        * Its one of pushing from subject to observer
        * */
    }
}
