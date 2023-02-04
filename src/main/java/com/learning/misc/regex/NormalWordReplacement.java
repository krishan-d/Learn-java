package com.learning.misc.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NormalWordReplacement {
    public static void main(String[] args) throws Exception {
        Pattern p = Pattern.compile("cat");
        Matcher m = p.matcher("one cat, " + "two cats in the yard");

        StringBuffer sb = new StringBuffer();
        boolean res = m.find();
        while (res) {
            m.appendReplacement(sb, "dog");
            res = m.find();
        }
        m.appendTail(sb);
        System.out.println(sb);
    }
}
