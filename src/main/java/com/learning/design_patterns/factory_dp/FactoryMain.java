package com.learning.design_patterns.factory_dp;

import com.learning.design_patterns.factory_dp.phone.*;

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

        OperatingSystemFactory osf = new OperatingSystemFactory();
        OS object = osf.getInstance("Closed");
        object.spec();
    }
}
