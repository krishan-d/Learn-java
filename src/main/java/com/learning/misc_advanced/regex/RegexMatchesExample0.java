/*
 * methods:
 * */
package com.learning.misc_advanced.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexMatchesExample0 {
    public static void main(String[] args) {
        //way 1
        Pattern p0 = Pattern.compile(".s");
        Matcher m0 = p0.matcher("as");
        boolean b0 = m0.matches(); //True

        //way 2
        boolean b1 = Pattern.compile(".s").matcher("as").matches(); //True

        //way 3
        boolean b2 = Pattern.matches(".s", "as"); //True
        System.out.println("b0 = " + b0 + " b1 = " + b1 + " b2 = " + b2);

        System.out.println(Pattern.matches(".s", "mas")); //False

        boolean b3 = Pattern.compile(".s").matcher("as").lookingAt(); //True

        System.out.println(Pattern.matches("[amn]", "abc")); //False
        System.out.println(Pattern.matches("[amn]", "a")); //True

        System.out.println(Pattern.matches("[amn]?", "a")); //True
        System.out.println(Pattern.matches("[amn]?", "aaa")); //False (a comes more than once)
        System.out.println(Pattern.matches("[amn]?", "am")); //False (a or m or n must come one time)

        System.out.println(Pattern.matches("[amn]+", "aaa")); //True


        System.out.println(Pattern.matches("\\d", "abc")); //False
        System.out.println(Pattern.matches("\\d", "100")); //False (Digit but comes more than once)
        System.out.println(Pattern.matches("\\d", "100F")); //False
        System.out.println(Pattern.matches("\\d", "1")); //True

        System.out.println(Pattern.matches("\\d", "100F")); //False

        String phoneNumberRegex = "(\\+91)(\\s?)(\\d{10})";
        System.out.println(Pattern.matches(phoneNumberRegex, "+91 7000022400")); //True
    }
}
