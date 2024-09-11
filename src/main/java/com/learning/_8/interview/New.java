package com.learning._8.interview;

import java.util.Arrays;
import java.util.List;

public class New {

    public static void main(String[] args) {


//        List<Integer> l = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> l = Arrays.asList(1, 2, 3);
        System.out.println(l); //5

        int sum = 0;
        int size = l.size();
        System.out.println(l.size());
        for (int i = 0; i < size; i += 2) {
            sum += l.get(i);
        }
        for (int k = 1; k < size; k+=2) {
            if (k == size-1 || k == size- 2) {
                break;
            }
            sum += l.get(k);
        }
        System.out.println(sum);
    }
}
