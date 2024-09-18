package com.learning._8.stream;

import com.learning._8.stream.model.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ComparatorDetails {
    public static void main(String[] args) {

        /*
        Summary of Key Methods:
            compare(T o1, T o2): The core comparison method.
            comparing(Function<T, U>): Creates a comparator based on a function.
            thenComparing(): Chains multiple comparators.
            reversed(): Reverses the sorting order.
            nullsFirst() and nullsLast(): Handles null values in comparisons.
            reverseOrder(): Reverses the natural order.

        Comparator Use Cases:
            Sorting collections using custom rules.
            Providing multiple sorting strategies for the same object.
            Handling null values while sorting.
         */

        List<Student> studentList = new ArrayList<Student>();

        studentList.add(new Student("Paul", 11, "Economics", 78.9));
        studentList.add(new Student("Zevin", 12, "Computer Science", 91.2));
        studentList.add(new Student("Harish", 13, "History", 83.7));
        studentList.add(new Student("Xiano", 14, "Literature", 71.5));
        studentList.add(new Student("Soumya", 15, "Economics", 77.5));


        // Static and Default methods in Comparator [Java 8]:

        // 1. comparing():
        // This static method can be used to create a Comparator for a specific field.
        studentList.sort(Comparator.comparing(Student::getName));

        // 2. thenComparing():
        // Used to chain comparators.

        // 3. reverseOrder():
        // Returns a comparator that reverses the natural order of elements.
        List<Integer> numbers = Arrays.asList(3, 1, 4, 2);
        numbers.sort(Comparator.reverseOrder());
        System.out.println(numbers);  // Output: [4, 3, 2, 1]

        // 4. nullsFirst() and nullsLast():
        // These methods return comparators that handle null values.
        // nullsFirst() places null before non-null values, while nullsLast() places null after non-null values.
        List<String> strings = Arrays.asList("a", null, "b", "c");
        strings.sort(Comparator.nullsFirst(Comparator.naturalOrder()));
        System.out.println(strings);  // Output: [null, a, b, c]

        // 5. naturalOrder():
        // Returns a comparator that compares objects in their natural order.
        // For example, for integers or strings, it will use the standard order (1 < 2 < 3, a < b < c).
        List<String> strings1 = Arrays.asList("a", "b", "c");
//        List<String> strings1 = Arrays.asList("a", null, "b", "c"); // gives Exception
        strings1.sort(Comparator.naturalOrder());
        System.out.println(strings1);  // Output: [a, b, c]


        // 6. reversed():
        // Returns a comparator that reverses the order of the current comparator.
//        people.sort(Comparator.comparing(Person::getAge).reversed());


        // Comparator vs Comparable :
        // Comparable :
        //      is used when a class has a natural ordering, and objects are compared to each other within the class
        //      using the compareTo() method.
        //      A class implements Comparable.
        // Comparator :
        //      is used when you want to define multiple or custom ways to compare objects outside the class itself.
        //      It does not modify the class and can be applied externally.

    }
}
