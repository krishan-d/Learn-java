package com.learning._8.stream.sorting;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortListDemo {

    public static void main(String[] args) {

//      List<Integer> iList = new ArrayList<>();
        List<Integer> iList = Arrays.asList(4, 0, 12, 3, 7, -4);
        Collections.sort(iList); // ASCENDING
        Collections.reverse(iList);

        iList.stream().sorted().forEach(System.out::println);
        iList.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);
    }
}
