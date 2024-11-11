package com.learning._16;

public class Basics {

    public static void main(String[] args) {

        // *** Vector API (Incubator): Provides a high-performance API for vectorized computation (SIMD).
        // *** Record

        // ZGC on macOS: Low-latency garbage collector support for macOS.
        // Foreign Function & Memory API (Incubator): A safer and more efficient alternative to JNI for working with native code and off-heap memory.
        // Pattern Matching for instanceof (Preview): Simplifies the instanceof check and cast in one operation.
        // Packaging Tool (Incubator): A tool for packaging Java applications into platform-specific installers.
        // Strong Encapsulation of JDK Internals: Stronger encapsulation of internal APIs, reducing reliance on private APIs.
        // DTLS and SSL reimplementation: Improved cryptographic stack for network communication.


        // 1. Vector API :
        // The Vector API provides a way for developers to write code that can take advantage of modern vector processing units
        // (SIMD — Single Instruction, Multiple Data). This allows Java applications to achieve higher performance
        // for workloads that benefit from parallel data processing, such as scientific computations and machine learning tasks.

        /*
        // Create a species for 256-bit vector of integers
        VectorSpecies<Integer> SPECIES = IntVector.SPECIES_256;

        // Allocate two vectors of integers from an array
        int[] array1 = {1, 2, 3, 4, 5, 6, 7, 8};
        int[] array2 = {8, 7, 6, 5, 4, 3, 2, 1};

        // Create vectors from arrays
        IntVector v1 = IntVector.fromArray(SPECIES, array1, 0);
        IntVector v2 = IntVector.fromArray(SPECIES, array2, 0);

        // Perform element-wise addition
        IntVector result = v1.add(v2);
        System.out.println("Result: " + result);

        */
        // Explanation
        // The VectorSpecies defines the type and size of the vector (e.g., IntVector.SPECIES_256 means a 256-bit vector of integers).
        // IntVector.fromArray() loads an array of integers into the vector.
        // The add() method performs a parallel addition of the two vectors.



        // 2. Pattern Matching for instanceof (preview) :
        // Java developer makes good use of instanceof conditions throughout the code.
        // Specifically, an instanceof conditional check is generally followed by a typecasting.
        // Old:
        Object obj = "Hi";
        if (obj instanceof String) {
            String str = (String) obj;  // You need to cast explicitly after the check
            System.out.println(str.toUpperCase());
        }

        if (obj instanceof String str) { // The pattern `String str` matches and casts `obj` to String
            System.out.println(str.toUpperCase()); // No need to cast explicitly
        }


        // Record:
        // Records:  Records are a new class type in Java 14 that offer a clear method to describe classes that are
        // primarily used to hold data.
        // They eliminate boilerplate code by automatically generating equals(), hashCode(), and toString() methods
        // as well as constructors and accessor methods [getters].

        Person p = new Person("A", 30);


    }
}
