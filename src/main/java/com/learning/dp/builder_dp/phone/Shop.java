package com.learning.dp.builder_dp.phone;

public class Shop {
    public static void main(String[] args) {
        //Phone p = new Phone("ios", 12, "bionic", 6.20, 4000);

        Phone pb = new PhoneBuilder().setOs("ios").setRam(12).setProcessor("bionic").setBattery(4000).getPhone();
        System.out.println(pb);
    }
}
