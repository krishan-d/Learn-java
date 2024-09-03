package com.learning._8.functional_interfaces;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class SupplierDemo {

    /**
     * Supplier can be used in all context where there is no input but an output is expected.
     * T get();
     */

    public static void main(String[] args) {

        Supplier<String> supplier = () -> "Hi Lyn!";
        System.out.println(supplier.get());

        List<Integer> iList1 = Arrays.asList(1, 2, 3, 4);
        System.out.println(iList1.stream().findAny().orElseGet(() -> 0));
        System.out.println(iList1.stream().findAny().orElse(0));

    }
}
