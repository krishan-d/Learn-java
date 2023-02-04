package com.learning.basicsl_and_oops.arrays;

import java.util.Arrays;
import java.util.List;

public class ArraysMethods {

    public static void main(String[] args) {
        int[] ar = {4, 6, 1, 8, 3, 9, 7, 4, 2};
        int[] ar1 = {};
        int[][] ar2 = {{7}, {4, 6}};
        int[ ] ar4 = {5, 1, 8, 3, 9, 10};

        List<Integer> array = Arrays.asList(1, 0, 3, 6, 9, 7, 4, 2);
        // List<Integer> arrayList1 = Arrays.asList(ar1); //CTE
        System.out.println(array);

        System.out.println(Arrays.toString(ar));

        System.out.println(Arrays.binarySearch(ar, 0));

        System.out.println(Arrays.compare(ar, ar1)); //-1

        int[] copyOfArray = Arrays.copyOf(ar, 5);
        System.out.println(Arrays.toString(copyOfArray));

        System.out.println(Arrays.toString(Arrays.copyOfRange(ar, 3, 7)));

        System.out.println("deepToString: " + Arrays.deepToString(ar2));
        System.out.println(Arrays.deepHashCode(ar2));

        System.out.println(Arrays.equals(ar, ar1));

        Arrays.fill(ar4, 0);
        System.out.println(Arrays.toString(ar1));

        System.out.println(Arrays.hashCode(ar));

        System.out.println("mismatch: " + Arrays.mismatch(ar, ar1));
        System.out.println("mismatch: " + Arrays.mismatch(ar1, ar4));

        System.out.println(Arrays.spliterator(ar));

        Arrays.sort(ar);
        System.out.println(Arrays.toString(ar));

        System.out.println(Arrays.stream(ar));
        Arrays.stream(ar).forEach(System.out::println);

        System.out.println();
        Arrays.stream(ar).filter(x -> (x > 2) && (x < 8)).forEach(System.out::println);

        //Wrapper List over array[]
        Integer[] ar3 = {6, 7, 3, 8, 0, 2, 5, 0};
        System.out.println("\nArray: " + Arrays.toString(ar3));
        List<Integer> arrayList = Arrays.asList(ar3);
        System.out.println(arrayList);

        Arrays.sort(ar3);
        System.out.println(Arrays.toString(ar3));

    }
}
