package com.learning.dp.creational.c_factory;

import com.learning.dp.creational.c_factory.os.Android;
import com.learning.dp.creational.c_factory.os.IOS;
import com.learning.dp.creational.c_factory.os.OS;
import com.learning.dp.creational.c_factory.os.Windows;

public class OsFactory {

    public OS getInstance(String str) {
        if (str.equalsIgnoreCase("android")) return new Android();
        if (str.equalsIgnoreCase("ios")) return new IOS();
        return new Windows();
    }
}
