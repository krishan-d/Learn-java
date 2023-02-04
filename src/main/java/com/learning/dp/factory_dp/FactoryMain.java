package com.learning.dp.factory_dp;

import com.learning.dp.factory_dp.os.*;

public class FactoryMain {

    public static void main(String[] args) {

        //OS ob = new Windows();
        //ob.spec();
        /*
        * problem:
        * created class object is visible to client.
        * For any change we have to recompile.
        *
        * Solution:
        * Factory design pattern
        * */

        OsFactory osf = new OsFactory();
        OS object = osf.getInstance("ios");
        object.spec();
    }
}
