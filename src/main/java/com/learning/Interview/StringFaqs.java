package com.learning.Interview;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

public class StringFaqs {

    public static void main(String[] args) {
        String input = "abac";
        List<String> substrings = getAllSubstrings(input);

        // Print all substrings
        substrings.forEach(System.out::println);
    }

    public static List<String> getAllSubstrings(String input) {
        int length = input.length();

        List<String > sList = IntStream.range(0, length)
                .boxed()
                .flatMap(i -> IntStream.range(i + 1, length + 1)
                        .mapToObj(j -> input.substring(i, j)))
                .filter(StringFaqs::uniqueCharacters)
                .toList();
        return sList;

        /*for (int i = 0; i < length; i++) {
            Set<Character> charSet = new HashSet<>();
            StringBuilder sb = new StringBuilder();

            for (int j = i; j < length; j++) {
                char c = input.charAt(j);
                if (!charSet.add(c)) {
                    break;  // Stop if a duplicate character is found
                }
                sb.append(c);
                result.add(sb.toString());
            }
        }*/
    }

    public static boolean uniqueCharacters(String subString) {
        Set<Character> set = new HashSet<>();
        for (char c : subString.toCharArray()) {
            if (!set.add(c)) {
                return false;
            }
        }
        return true;
    }
}

