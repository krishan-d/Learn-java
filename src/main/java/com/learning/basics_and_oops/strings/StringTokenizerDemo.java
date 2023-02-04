package com.learning.basics_and_oops.strings;

import java.util.StringTokenizer;

public class StringTokenizerDemo {

    public static void main(String[] args) {

        /*
         * StringTokenizer:
         * To break string into tokens based on provided delimiter.
         * */

        String dL = " : ";
        String str1 = "Hi : Krishna : ! : Good : Evening : .";
        StringTokenizer sT = new StringTokenizer(str1, dL);
        int tokenCount = sT.countTokens();
        for (int k = 0; k < tokenCount; k++) {
            System.out.println("Token[" + k + "] : " + sT.nextToken());
        }

        StringTokenizer sT1 = null;
        while (true) {
            assert sT1 != null;
            if (!sT1.hasMoreTokens()) break;
            System.out.println(sT1.nextToken());
        }
    }
}
