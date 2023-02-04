/*
 * start() and end()
 * */
package com.learning.misc_advanced.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexMatchesExample1 {
    private static final String REGEX = "\\bHey\\b";
    private static final String INPUT = "Hey Hey Hey Hii Hello Hey";

    public static void main(String[] args) {
        Pattern p = Pattern.compile(REGEX);
        Matcher m = p.matcher(INPUT);
        int count = 0;

        while (m.find()) {
            count++;
            System.out.println("Match number: " + count);
            System.out.println("start index: " + m.start());
            System.out.println("end(): " + m.end());
        }
    }
}
