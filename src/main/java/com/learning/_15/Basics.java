package com.learning._15;

import java.lang.invoke.MethodHandles;
import java.lang.reflect.InvocationTargetException;

public class Basics {

    public static void main(String[] args) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException, InstantiationException {


        // *** Hidden Classes: Enable dynamic creation of classes for use in frameworks.

        // EdDSA: New cryptographic algorithms (Ed25519, Ed448) for signing data.
        // Sealed Classes (Preview): Restrict which classes can extend a given class.
        // ZGC on macOS: Low-latency garbage collector now available on macOS.
        // Pattern Matching for instanceof (Preview): Simplifies instanceof checks and casts.
        // Text Blocks: Simplifies multi-line string literals.
        // Records (Preview): Introduces a simpler, boilerplate-free way of creating data classes.
        // Shenandoah GC: Experimental low-latency garbage collector.


        // Hidden Classes:
        /*
        Hidden classes are classes that are not part of the public API and are intended for use by frameworks
        that generate classes at runtime. These classes are not accessible by name through reflection or classloaders,
        and they are primarily used to support dynamic languages or other frameworks that generate classes during runtime.

        Hidden classes enable more efficient and cleaner class generation by allowing these classes to
        be created and discarded more easily, without impacting the public API or causing issues with reflection.
         */

        // Create a MethodHandles.Lookup object
        MethodHandles.Lookup lookup = MethodHandles.lookup();

        // Define a hidden class
        Class<?> hiddenClass = lookup.defineClass(
                "class Hidden { void sayHello() { System.out.println(\"Hello from Hidden!\"); } }".getBytes()
        );

        // Instantiate and invoke method on the hidden class
        Object instance = hiddenClass.getDeclaredConstructor().newInstance();
        hiddenClass.getMethod("sayHello").invoke(instance);

        // Explanation:
        // MethodHandles.lookup().defineClass() dynamically defines a hidden class.
        // The class is created and used only in the context of the program, without being accessible to other parts of the application.



        // 6. Text Block
        String json = """
            {
                "name": "John Doe",
                "age": 30,
                "address": {
                    "street": "123 Main St",
                    "city": "Noida"
                }
            }
            """;
    }
}
