package com.learning._2_basics_and_oops.arrays;

import java.util.Arrays;

public class CopyingArray {

    public static void main(String[] args) {
        // Copying using assignment operator

        int[] numbers = {1, 2, 3, 4, 5, 6};
        int[] positiveNumbers = numbers;    // copying arrays

        numbers[0] = -1;
        /*
         * changing in numbers array cause change in second(copy) array too, because
         * both array refer to the same object.
         * */

        for (int number : positiveNumbers)
            System.out.print(number + " ");


        // Using Looping Construct:
        int[] source = {1, 2, 3, 4, 5, 6};
        int[] destination = new int[6];

        for (int i = 0; i < source.length; ++i) {
            destination[i] = source[i];
        }
        System.out.println("\nDestination Array: " + Arrays.toString(destination));


        // Using arraycopy() method:
        int[] n1 = {2, 3, 12, 4, 12, -2};
        // Creating n2 array of having length of n1 array
        int[] n2 = new int[n1.length];
        int[] n3 = new int[5];

        // copying entire n1 array to n2
        System.arraycopy(n1, 0, n2, 0, n1.length);
        System.out.println("n2 = " + Arrays.toString(n2));

        // copying elements from index 2 on n1 array copying element to index 1 of n3 array
        // 2 elements will be copied
        System.arraycopy(n1, 2, n3, 1, 2);
        System.out.println("n3 = " + Arrays.toString(n3));


        // Using copyOfRange() method:
        // int[] destination1 = Arrays.copyOfRange(source, 0, source.length)

        int[] s = {2, 3, 12, 4, 12, -2};
        // copying entire source array to destination
        int[] d1 = Arrays.copyOfRange(s, 0, source.length);
        System.out.println("destination1 = " + Arrays.toString(d1));
        // copying from index 2 to 5 (5 is not included)
        int[] d2 = Arrays.copyOfRange(s, 2, 5);
        System.out.println("destination2 = " + Arrays.toString(d2));


        // Copying 2d Arrays using arraycopy():
        int[][] s1 = {
                {1, 2, 3, 4},
                {5, 6}};
        System.out.println(Arrays.deepToString(s1));
        int[][] d3 = new int[s1.length][];

        for (int i = 0; i < s1.length; ++i) {
            d3[i] = new int[s1[i].length];
            System.arraycopy(s1[i], 0, d3[i], 0, d3[i].length);
        }
        System.out.println(Arrays.deepToString(d3));
    }
}
