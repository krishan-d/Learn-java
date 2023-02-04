package com.learning.basicsl_and_oops.strings;

public class StringBufferDemo {

    public static void main(String[] args) {

        /*
         * StringBuffer:
         * MUTABLE string object
         * Used when we have to make many modifications in string
         * THREAD-SAFE : Multiple threads can't access it simultaneous.
         * SYNCHRONIZED
         * Storage area is Heap
         * Moderate performance and consumes more Memory
         * DEFAULT BUFFER SIZE = 16
         *
         * Constructors:
         * StringBuffer()
         * StringBuffer(int size)
         * StringBuffer(String str)
         * StringBuffer(CharSequence[] ch)
         * */

        StringBuffer sb = new StringBuffer("Hi");

        // Methods:
        // append()
        sb.append("\sEve!");
        sb.append(10);
        System.out.println("StringBuffer: " + sb);

        // insert()
        sb.insert(2, "i...");
        System.out.println(sb);

        // sb.reverse();

        // replace()
        sb.replace(7, 10, "Edwina");
        System.out.println("StringBuffer: " + sb);

        // capacity()
        StringBuffer sb1 = new StringBuffer();
        System.out.println(sb1.capacity());  // 16

        // ensureCapacity()
        sb1.ensureCapacity(32); // More than existing capacity
        // [RULE: NEW CAPACITY = (OLD CAPACITY * 2) + 2]
        System.out.println(sb1.capacity()); // 34 [(16 * 2) + 2 = 34]

    }
}
