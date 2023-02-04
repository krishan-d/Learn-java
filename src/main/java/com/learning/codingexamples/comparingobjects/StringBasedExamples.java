package com.learning.codingexamples.comparingobjects;

import org.jetbrains.annotations.NotNull;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringBasedExamples {

    public static void main(String[] args) {

        //1. Difference between equals() and == operator?
        //equals() method matches value of strings whereas == operator matches object or reference of strings.

        //2. Is String class final?
        //Yes

        //3. Reverse String
        //String str = "";
        //StringBuilder sb = new StringBuilder(str);
        //sb.reverse();

        //4. Is Palindrome String?
        //boolean isPalindrome = isPalindrome("TENET");
        //System.out.println(isPalindrome);

        //5. Capitalize each word in string?
        //capitalizeEachWord("i Am NOT GooD!");

        //6. reverse each word in string?
        //reverseEachWord("Hi Everyone !");

        //7. Toggle as iAM, each word in string ?
        //toggleEachWord("Hi There!");

        //8. Is strings are anagram?
        //boolean isAnagram = isAnagram("Mother In Law", "Hitler Woman");
        //System.out.println(isAnagram);

        // Find duplicate characters in a string
        //duplicateCharFind("Hi Edwina, How are you?");

        // Is rotation of another string?
        //boolean isRotation = isRotationalString("avajava", "javaava");
        //System.out.println(isRotation);

        // Swap without third variable?
        //swapWithoutThirdVariable("Hi", "Hello");

        // Remove particular character?
        //String string1 = removeParticularChars("Hi Edwina, How are you?", 'o');
        //System.out.println(string1);

        // count the number of word in a string?
        //countNumberOfWords("Hi Eve! How are you?. Did you see Eve now a days? Hi Edwina, ho I did not.");

        //fun2("000.12.12.034");


        fun3();

    }
    //4
    public static boolean isPalindrome(String str) {
        if (str == null) return true;
        StringBuilder sb = new StringBuilder(str);
        return (str.equals(sb.reverse().toString()));
    }

    //5
    public static void capitalizeEachWord(String str) {
        String[] array = str.split("\s");
        StringBuilder string = new StringBuilder();
        for (String s : array) {
            String i = s.substring(0, 1);
            String r = s.substring(1);
            string.append(i.toUpperCase()).append(r.toLowerCase()).append("\s");
        }
        System.out.println(string);
    }

    //6
    public static void reverseEachWord(String str) {
        String[] array = str.split("\s");
        StringBuilder string = new StringBuilder();
        for (String s : array) {
            string.append(new StringBuilder(s).reverse()).append("\s");
        }
        System.out.println(string);
    }

    //7
    public static void toggleEachWord(String str) {
        String[] array = str.split("\s");
        StringBuilder string = new StringBuilder();
        for (String s : array) {
            String i = s.substring(0, 1);
            String r = s.substring(1);
            string.append(i.toLowerCase()).append(r.toUpperCase()).append("\s");
        }
        System.out.println(string);
    }

    //8
    public static boolean isAnagram(@NotNull String s1, String s2) {
        //Anagram : Strings contain same set of characters but in different order.
        if (s1.isEmpty() && s2.isEmpty()) return true;
        s1 = s1.replaceAll("\s", "");
        s2 = s2.replaceAll("\s", "");
        if (s1.length() != s2.length()) return false;

        char[] array1 = s1.toLowerCase().toCharArray();
        char[] array2 = s2.toLowerCase().toCharArray();
        Arrays.sort(array1);
        Arrays.sort(array2);
        return Arrays.equals(array1, array2);
    }

    public static void duplicateCharFind(String str) {

        Map<Character, Integer> map = new HashMap<>();
        char[] array = str.toCharArray();
        for (char c : array) {
            if (map.containsKey(c)) map.put(c, map.get(c) + 1);
            else map.put(c, 1);
        }

        Set<Character> s = map.keySet();
        for (Character c : s) {
            if (map.get(c) > 1) System.out.println(c + "\sis\s" + map.get(c) + "\stimes" );
        }
    }

    public static boolean isRotationalString(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        String s3 = s1.concat(s1);
        return s3.contains(s2);
    }

    public static void swapWithoutThirdVariable(String s1, String s2) {
        s1 = s1 + s2;
        s2 = s1.substring(0, s1.length() - s2.length());
        s1 = s1.substring(s2.length());
        System.out.println("s1: " + s1);
        System.out.println("s2: " + s2);
    }

    public static String removeParticularChars(String s1, char ch) {
        return s1.replace(ch, '\b').replaceAll("\b", "");
    }

    public static void countNumberOfWords(String str) {
        String[] array = str.split("\s");
        Map<String, Integer> map = new HashMap<>();
        for (String s : array) {
            if (map.containsKey(s)) map.put(s, map.get(s) + 1);
            else map.put(s, 1);
        }

        Set<String> set = map.keySet();
        for (String s : set) {
            if (map.get(s) > 1) System.out.println(s + " : count = " + map.get(s));
        }
    }


    public static void splitUsingRegex(String s) {
        if (!s.matches("[A-Za-z !,?._'@]+")) return;

        String[] arr = s.split("[! ,?._'@]+");
        System.out.println(arr.length);

        for (String str : arr) {
            System.out.println(str);
        }
    }

    public static void fun2(String s) {
        String regex = "";
        final String pattern = regex + "." + regex + "." + regex + "." + regex;
        System.out.println(s.matches(pattern));
    }

    public static void fun3() {
        String regex = "\\b(\\w+)(?:\\W+\\1\\b)+"; // \\b(\\w+)(\\s+\\1\\b)*
        Pattern p = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);

        Scanner in = new Scanner(System.in);
        int numSentences = Integer.parseInt(in.nextLine());

        while (numSentences-- > 0) {
            String input = in.nextLine();

            Matcher m = p.matcher(input);

            // Check for subsequences of input that match the compiled pattern
            while (m.find()) {
                input = input.replaceAll(m.group(0), m.group(1));
            }

            // Prints the modified sentence.
            System.out.println(input);
        }
        in.close();
    }

    public static void replaceHtmlTags(String s) {
        s = s.replaceAll("<\\/?[^<>]+>", " ").replaceAll("\\s+", " ").trim();
    }

}
