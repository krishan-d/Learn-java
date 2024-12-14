package com.learning.dp.creational.c_factory;

import com.learning.dp.creational.c_factory.os.*;

public class OsFactory {

    public OS getOsInstance(OsType osType) {
        /*if (str.equalsIgnoreCase("android")) return new Android();
        if (str.equalsIgnoreCase("ios")) return new IOS();
        return new Windows();*/

        if (osType == OsType.ANDROID) return new Android();
        if (osType == OsType.IOS) return new IOS();
        return new Windows();
    }
}
