package com.learning.basicsll_and_collections.annotations.annotation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Annotations {
    /*
     * Java annotations are metadata (data about data) for our program source code.
     *
     * Syntax:
     * @AnnotationName
     *
     * Annotation Formats...
     * Marker Annotations:
     * do not contain members/elements. It is only used for marking a declaration.
     * Ex: @Override
     *
     * One element Annotation:
     * Syntax:
     * @AnnotationName(elementName = "elementValue")
     * @AnnotationName(value = "elementValue")
     * @AnnotationName("elementValue")
     *
     * More element Annotations:
     * @AnnotationName(e1 = "v1", e2 = "v2", ...)
     *
     * Annotation Types...
     * Predefined annotations:
     * @Deprecated
     * @Override
     * @SuppressWarnings
     * @FunctionalInterface
     * @safeVarargs
     *
     * Meta-annotations:
     * @Retention
     * @Documented
     * @Target
     * @Inherited
     * @Repeatable
     *
     * Custom-annotations:
     *
     * Apps:
     * Compiler
     * */


    /*
     * @Deprecated
     * This method is deprecated and has been replaced by newMethod()
     * */
    @Deprecated
    public static void deprecatedMethod() {
        System.out.println("Deprecated method!");
    }

    /*
     * @Override:
     *
     * if we use it, the compiler gives an error if something is wrong (such as wrong parameter type) while overriding the method.
     * */
    static class Person {
        public void show() {
            System.out.println("Person");
        }
    }

    static class Student extends Person {
        @Override
        public void show() {
            // super.show();
            System.out.println("Student");
        }

        public void printMessage() {
            show();
        }
    }

    /*
     * @SuppressWarnings
     * instructs the compiler to suppress warnings that are generated while the program executes.
     *
     * The warnings that can be suppressed are compiler-specific but there are two categories of warnings: deprecation and unchecked.
     * Ex:
     * @SuppressWarnings("deprecated")
     * And
     * @SuppressWarnings({"deprecated", "unchecked"})
     *
     * category [deprecated] instructs the compiler to suppress warning when we use a deprecated element.
     * category [unchecked] instruct the compiler to suppress warning when we use raw types.
     * */

    @SuppressWarnings("unchecked")
    static void wordsList() {
        ArrayList<String> wordList = new ArrayList<>();
        wordList.add("Hi");
    }

    /*
     * @SafeVarargs
     * The @SafeVarargs annotation asserts that the annotated method or constructor does not perform,
     * unsafe operations on its varargs (variable number of arguments).
     * Use this annotation on methods or constructors that cannot be overridden.
     * */

    @SafeVarargs
    private void showList(List<String>... lists) {
        // [List] [...lists] specifies a variable-length argument of type [List],
        // means showList() can have zero or more arguments.

        /*
         * Without @SafeVarargs:
         * No compile errors but gives warnings.
         *
         * With @SafeVarargs:
         * we get same output but without any warnings.
         * Unchecked warnings are also suppressed.
         * */
        for (List<String> list : lists) {
            System.out.println(list);
        }
    }

    /*
     * @FunctionalInterface:
     * This annotation indicates that the type declaration on which it is used is a functional interface.
     * A functional interface can have only one abstract method.
     *
     * Not mandatory to use @FunctionalInterface annotation.
     * The compiler considers any interface that meets the functional interface definition as a functional interface.
     *
     * Can have any number of default and static methods, because they have an implementation.
     * */
    @FunctionalInterface
    public interface FunctionInterface {
        public void method();  // Abstract method

        // public void otherMethod();  // Throws compile error
        default void someMethod() {
        }
    }

    @SuppressWarnings("deprecated")
    public static void main(String[] args) {

        // deprecatedMethod(); // without SuppressWarnings on main

        Student s = new Student();
        s.printMessage();

        Annotations a = new Annotations();
        a.deprecatedMethod();  // with SuppressWarnings on main

        wordsList();


        List<String> uList = Arrays.asList("Edwina", "Eve");
        a.showList(uList);

        List<String> pList = Arrays.asList("Python", "Java");
        a.showList(uList, pList);

    }

}
