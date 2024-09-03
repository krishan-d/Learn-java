package com.learning._2_basics_and_oops.oops;

import java.util.HashSet;
import java.util.Set;

public class IBDoubleBraceDemo {

    public static void main(String[] args){
        Set<String> stringSets = new HashSet<String>()
        {
            {
                add("set1");
                add("set2");
                add("set3");
            }
        };
        /*
        NOTE:
        The first brace does the task of creating an anonymous inner class that has the capability of accessing the parent class’s behavior.
        In our example, we are creating the subclass of HashSet so that it can use the add() method of HashSet.
        The second braces do the task of initializing the instances.
         */

        doSomething(stringSets);
    }

    private static void doSomething(Set<String> stringSets){
        System.out.println(stringSets);
    }
}