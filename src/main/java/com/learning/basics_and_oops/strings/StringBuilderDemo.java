package com.learning.basics_and_oops.strings;

public class StringBuilderDemo {

    public static void main(String[] args) {

        /*
         * StringBuilder:
         * Identical to StringBuffer except one difference that it's not synchronized, which means NOT THREAD SAFE.
         * To create mutable and non-synchronized string object.
         * NOT SYNCHRONIZED
         * NOT THREAD-SAFE
         * MUTABLE
         * Storage area is Stack
         * High performance and consume Less Memory
         *
         * Constructors:
         * StringBuilder(): creates empty StringBuilder and reserve space 16 characters
         * StringBuilder(int size)
         * StringBuilder(String str)
         * StringBuilder(CharSequence seq)
         * */

        StringBuilder sbd = new StringBuilder();

        //append()
        sbd.append("Hi\s");
        sbd.append(11);

        //insert()
        sbd.insert(2, "INSERTED!");

        //replace()
        sbd.replace(3, 5, "Krishna");
        System.out.println(sbd);

        //delete()
        sbd.delete(2, 3);

        sbd.reverse();
        System.out.println(sbd);
    }

    public static void concat1(String s1) { s1 = s1 + "Extended!"; }

    public static void concat2(StringBuilder s2) { s2.append("Extended!"); }

    public static void concat3(StringBuffer s3) { s3.append("Extended!"); }

    public static void mutabilityExample() {

        //Mutability String vs StringBuilder vs StringBuffer:
        String s1 = "Task";
        concat1(s1); //s1 is not changes hence, Immutable
        System.out.println("String: " + s1);

        StringBuilder s2 = new StringBuilder("Task");
        concat2(s2); //s2 is changed hence, Mutable
        System.out.println("StringBuilder: " + s2);

        StringBuffer s3 = new StringBuffer("Task");
        concat3(s3); //s3 is changed hence, Mutable
        System.out.println("StringBuffer: " + s3);
    }
}
