package com.learning.dp.factory_dp;

import com.learning.dp.factory_dp.os.Android;
import com.learning.dp.factory_dp.os.IOS;
import com.learning.dp.factory_dp.os.OS;
import com.learning.dp.factory_dp.os.Windows;

public class OsFactory {

    public OS getInstance(String str) {
        if (str.equalsIgnoreCase("android")) return new Android();
        if (str.equalsIgnoreCase("ios")) return new IOS();
        return new Windows();
    }
}
