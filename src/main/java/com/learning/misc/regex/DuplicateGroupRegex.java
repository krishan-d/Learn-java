package com.learning.misc.regex;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DuplicateGroupRegex {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int testCases = Integer.parseInt(in.nextLine());
        while(testCases > 0){
            String line = in.nextLine();

            boolean isFound = false;

            String regex = "<([\\w\\W]+)>([^<>]+)<\\/(\\1)>";
            Matcher m = Pattern.compile(regex).matcher(line);
            while (m.find()) {
                System.out.println(m.group(2));
                isFound = true;
            }
            if (!isFound) {System.out.println("None");}

            testCases--;
        }
        in.close();


        // \\1 is a back reference
        // corresponding in this case to the first capturing group which is (a) here.

        Pattern p1 = Pattern.compile("(a)\\1*");
        Pattern p2 = Pattern.compile("(a)");

        Matcher m1 = p1.matcher("aa");
        Matcher m2 = p2.matcher("aa");

        m1.find();
        System.out.println(m1.group());

        m2.find();
        System.out.println(m2.group());


        Matcher m3 = p1.matcher("aaaaaabbbaaaabaa");
        while (m3.find()) System.out.println(m3.group());
    }
}
