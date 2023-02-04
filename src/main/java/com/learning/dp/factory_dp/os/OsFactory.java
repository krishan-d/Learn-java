package com.learning.dp.factory_dp.os;

public class OsFactory {

    public OS getInstance(String str) {
        if (str.equalsIgnoreCase("android")) return new Android();
        if (str.equalsIgnoreCase("ios")) return new IOS();
        return new Windows();
    }
}
