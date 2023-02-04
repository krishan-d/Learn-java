/*
 * appendReplacement and appendTail
 * */
package com.learning.misc.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexMatchesExample2 {
    private static final String REGEX = "a*b";
    private static final String INPUT = "aabfooaabfooabfoobbfoo";
    private static final String REPLACE = "-";

    public static void main(String[] args) {
        Pattern p = Pattern.compile(REGEX);
        Matcher m = p.matcher(INPUT);

        StringBuffer sb = new StringBuffer();
        while (m.find()) {
            m.appendReplacement(sb, REPLACE);
        }
        m.appendTail(sb);
        System.out.println(sb);
    }
}
