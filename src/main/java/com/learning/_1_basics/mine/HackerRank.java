package com.learning._1_basics.mine;

import java.util.HashSet;

public class HackerRank {
    public static void main(String[] args) {

//        System.out.println(getSmallestAndLargest("welcometojava", 3));

        String str = "CAT";
        String bs = "Tac";
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < str.length(); i++)
            set.add(str.charAt(i));
    }


    public static String getSmallestAndLargest(String s, int k) {
        String S = s.substring(0, k);
        String L = "";

        int size = s.length();

        for (int i = 0; i <= size - k; i++) {
            String sub = s.substring(i, i+k);

            if (sub.compareTo(S) < 0) S = sub;
            if (sub.compareTo(L) >= 0) L = sub;
        }

        return S + "\n" + L;
    }
}
