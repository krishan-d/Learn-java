package com.learning._8.stream.sorting;

import com.learning._8.stream.model.Employee;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class SortMapDemo {

    public static void main(String[] args) {

        Map<String, Integer> map = new HashMap<>();
        map.put("EI", 8);
        map.put("FO", 4);
        map.put("TE", 10);
        map.put("TW", 2);

        map.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEach(System.out::println);
        map.entrySet().stream().sorted(Map.Entry.comparingByValue()).forEach(System.out::println);

        Map<Employee, Integer> empMap = new TreeMap<>();
        empMap.put(new Employee(1, "Mark", 200000.0), 60);
        empMap.put(new Employee(2, "Eve", 200000.0), 100);
        empMap.put(new Employee(3, "Zane", 300000.0), 40);

        // 1.0
        empMap.entrySet().stream()
                .sorted(Map.Entry.comparingByKey(
                        Comparator.comparing(Employee::getSalary).reversed()))
                .forEach(System.out::println);


        // 1.1
        /*Comparator<Map.Entry<Employee, Object>> comparator = Map.Entry.comparingByKey(
                Comparator.comparing(Employee::getSalary).reversed().thenComparing(Employee::getId));
        empMap.entrySet().stream()
                .sorted((Comparator<? super Map.Entry<Employee, Integer>>) comparator)
                .forEach(System.out::println);*/
        // or
        empMap.entrySet().stream()
                .sorted(
                        Map.Entry.comparingByKey(
                                Comparator.comparing(Employee::getSalary).reversed().thenComparing(Employee::getId)))
                .forEach(System.out::println);

    }
}
