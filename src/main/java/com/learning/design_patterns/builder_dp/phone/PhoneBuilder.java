package com.learning.design_patterns.builder_dp.phone;

// Builder Pattern - Creation Design Pattern
public class PhoneBuilder {
    private String os;
    private int ram;
    private String processor;
    private double screen_size;
    private int battery;

    public PhoneBuilder setOs(String os) {
        this.os = os;
        return this;
    }

    public PhoneBuilder setRam(int ram) {
        this.ram = ram;
        return this;
    }

    public PhoneBuilder setProcessor(String processor) {
        this.processor = processor;
        return this;
    }

    public PhoneBuilder setScreen_size(double screen_size) {
        this.screen_size = screen_size;
        return this;
    }

    public PhoneBuilder setBattery(int battery) {
        this.battery = battery;
        return this;
    }

    public Phone getPhone() {
        return new Phone(os, ram , processor, screen_size, battery);
    }
}
