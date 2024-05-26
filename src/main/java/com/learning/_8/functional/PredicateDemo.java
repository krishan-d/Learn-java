package com.learning._8.functional;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

//public class PredicateDemo implements Predicate<Integer> {
public class PredicateDemo {

    /**
     * Predicate is used for conditional check
     */

    public static void main(String[] args) {
        /*Predicate<Integer> predicate = new PredicateDemo();
        System.out.println(predicate.test(4));*/

        Predicate<Integer> predicate = x -> x % 2 == 0;
        System.out.println(predicate.test(4));

        List<Integer> iList1 = Arrays.asList(1, 2, 3, 4);
        iList1.stream().filter(predicate).forEach(System.out::println);

    }

    /*@Override
    public boolean test(Integer integer) {
        return integer % 2 == 0;
    }

    @NotNull
    @Override
    public Predicate<Integer> and(@NotNull Predicate<? super Integer> other) {
        return Predicate.super.and(other);
    }

    @NotNull
    @Override
    public Predicate<Integer> negate() {
        return Predicate.super.negate();
    }

    @NotNull
    @Override
    public Predicate<Integer> or(@NotNull Predicate<? super Integer> other) {
        return Predicate.super.or(other);
    }*/
}
