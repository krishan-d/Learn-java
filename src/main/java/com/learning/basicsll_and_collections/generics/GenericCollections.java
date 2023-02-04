package com.learning.basicsll_and_collections.generics;

import java.util.*;


public class GenericCollections {

    public static void main(String[] args) {

        //Generic collections
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "Eve");
        map.put(2, "Edwina");

        for (Integer integer : map.keySet()) { System.out.println(integer); }
        System.out.println();


        //1. wildcards upper-bounded
        List<Integer> integerList = Arrays.asList(1, 2, 3);
        System.out.println("sum = " + sum(integerList));


        //2. unbounded wildcard
        printAll(integerList);


        //3. wildcard lower bounded
        List<Animal> animalList = new ArrayList<>();
        List<Cat> catList = new ArrayList<>();
        List<RedCat> redCatList = new ArrayList<>();
        List<Dog> dogList = new ArrayList<>();

        addCat(animalList);
        addCat(catList);
        //addCat(redCatList); //CTE : can not add list of subclass RedCat of Cat class
        //addCat(dogList); //CTE : can not add list of subclass Dog of Superclass Animal of Cat class

        List<Number> l = new ArrayList<>();
        addIntegers(l);
        addIntegers(Collections.singletonList(new ArrayList<Double>()));


        //Subtyping using Generic Wildcard
        List<? extends Number> numList = new ArrayList<Integer>(); //OK, List<? extends Integer> is subType of List<? extends Number>

    }

    //Generic Wildcards Upper Bounded
    //Method that only accepts child classes of Shape
    public static double sum(List<? extends Number> numberList) {
        double sum = 0.0;
        for (Number n : numberList) sum += n.doubleValue();
        return sum;
    }

    //Generic Unbounded wildcard
    public static void printAll(List<?> list) {
        for (Object ob : list) System.out.println(ob + "::");
    }

    //Generic Wildcard Lower Bounded
    public static void addIntegers(List<? super Integer> list) {
        list.add(10);
    }

    public static void addCat(List<? super Cat> catList) {
        System.out.println("Cat Added");
    }

}
