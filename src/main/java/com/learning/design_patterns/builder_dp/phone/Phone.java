package com.learning.design_patterns.builder_dp.phone;

public class Phone {

    private String os;
    private int ram;
    private String processor;
    private double screen_size;
    private int battery;

    public Phone(String os, int ram, String processor, double screen_size, int battery) {
        this.os = os;
        this.ram = ram;
        this.processor = processor;
        this.screen_size = screen_size;
        this.battery = battery;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "os='" + os + '\'' +
                ", ram=" + ram +
                ", processor='" + processor + '\'' +
                ", screen_size=" + screen_size +
                ", battery=" + battery +
                '}';
    }
}
