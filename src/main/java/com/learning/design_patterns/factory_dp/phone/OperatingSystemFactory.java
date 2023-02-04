package com.learning.design_patterns.factory_dp.phone;

public class OperatingSystemFactory {
    public OS getInstance(String str) {
        if (str.equals("Open")) return new Android();
        if (str.equals("Closed")) return new IOS();
        return new Windows();
    }
}
