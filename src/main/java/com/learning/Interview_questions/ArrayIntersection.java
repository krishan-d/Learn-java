package com.learning.Interview_questions;

import java.util.*;

public class ArrayIntersection {
    public static void main(String[] args) {
        int[] arr1 = {80, 10, 15, 2, 35, 60};
        int[] arr2 = {35, 80, 60, 20, 75};

        printIntersection(arr1, arr2);

        printUnion(arr1, arr2);
    }

    static void printIntersection(int[] array1, int[] array2) {
        Set<Integer> s = new HashSet<>();
        for (int i : array1) {
            s.add(i);
        }

        for (int i : array2) {
            if (s.contains(i)) System.out.println(i);
        }
    }
    static void printUnion(int[] array1, int[] array2) {
        Set<Integer> s = new HashSet<>();
        for (int i : array1) {
            s.add(i);
        }

        for (int i : array2) {
            s.add(i);
        }

        System.out.println(s);

    }
}
