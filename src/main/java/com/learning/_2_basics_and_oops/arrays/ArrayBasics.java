package com.learning._2_basics_and_oops.arrays;

import java.util.Arrays;

public class ArrayBasics {

    public static void main(String[] args) {
        /*
        * Array:
        * dataType[] arrayName; // declaration
        * */

        //Creation
        int[] intArray = new int[4];
        String[] array = new String[10];
        //byte[] byteArray = new byte[2];

        System.out.println(intArray.getClass() + " | " + intArray.getClass().getSuperclass());
        System.out.println(array.getClass() + " | " + array.getClass().getSuperclass());

        int arrayLength = intArray.length;

        // Accessing array item
        int num = intArray[2];

        int[] numArray = {2, -9, 0, 5, 12, 8, -10, 4};
        System.out.println("1-D Array: " + Arrays.toString(numArray));  // print 1-d array
        int sum = 0;
        for (int n : numArray) { sum += n; }


        // 2-d Array
        double[][] matrix = {{1.2, 4.0, 3.4}, {4.1, -1.1}};
        // print 2-d array
        System.out.println("2-D Array: " + Arrays.deepToString(matrix));

        //int[][] array2d = new int[2][3];
        //int[][][] array3d = new int[2][3][4];

        //2-D Array Iteration
        int[][] matrixArray = {{1, -2, 3}, {-4, -5, 6, 7}, {0}};
        for (int[] row : matrixArray) {
            for (int data : row)
                System.out.print(data + " ");
        }


        //1. Concatenate Two Array using arraycopy():
        int[] array1 = {1, 2, 3};
        int[] array2 = {4, 5, 6};

        int aLen = array1.length;
        int bLen = array2.length;
        int size = aLen + bLen;
        int[] resArray = new int[size];

        System.arraycopy(array1, 0, resArray, 0, aLen);
        System.out.println("\nSystem.arrayCopy: " + Arrays.toString(resArray));

        System.arraycopy(array2, 0, resArray, aLen, bLen);
        System.out.println("\nSystem.arrayCopy: " + Arrays.toString(resArray));

        //2. Concatenate Two Array using iteration
        int[] concatenatedArray = new int[size];
        int pos = 0;
        for (int item : array1) {
            concatenatedArray[pos] = item;
            pos++;
        }

        for (int item : array2) {
            concatenatedArray[pos] = item;
            pos++;
        }
        System.out.println("\nConcatenated Array: " + Arrays.toString(concatenatedArray));

    }
}
