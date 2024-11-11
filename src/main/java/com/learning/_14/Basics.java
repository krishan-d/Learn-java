package com.learning._14;

public class Basics {

    public static void main(String[] args) {


        // *** Helpful NullPointerExceptions: Provides more detailed information in NullPointerException messages.
        // *** Switch Expressions (Standard): Makes switch more flexible and expressive.

        // Pattern Matching for instanceof (Preview): Simplifies type-checking and casting in instanceof checks.
        // Remove Nashorn JavaScript Engine: Deprecated the outdated Nashorn engine.
        // Deprecate the Security Manager: Indicates future removal of the Security Manager.
        // Remove Solaris and SPARC Ports: Removes support for Solaris and SPARC architectures.
        // Improve Non-Volatile Memory (NVM) Support: Enhances support for persistent memory.
        // Unix-Domain Socket Support: Adds native support for Unix-domain sockets for IPC.
        // Reimplement Legacy Datagram Transport Layer Security (DTLS): Re-implementation of DTLS for secure communication over UDP.


        // 2. Helpful NullPointerExceptions (Preview)
        // Old:
        /* int[] arr = null;
        arr[0] = 1; */
        // java.lang.NullPointerException at com.learning._14.Basics.main(Basics.java:21)

        // Now:
        // java.lang.NullPointerException: Cannot store to int array because "arr" is null at com.learning._14.Basics.main(Basics.java:21)


        // 3. Changes in Switch expressions:
        // Switch expressions will now be used as a statement as well as expressions.
        // This makes code simplification and pattern matching possible for the switch.
        // Now, the new Arrow syntax for switch introduced as
        // case X -> {}

        // Old syntax:
        int dayOfWeek = 3;
        String dayType = "";
        switch (dayOfWeek) {
            case 1:
            case 7:
                dayType = "Weekend";
                break;
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                dayType = "Weekday";
        }

        // New syntax:

        dayType = switch (dayOfWeek) {
            case 1, 7 -> "Weekend";
            case 2, 3, 4, 5, 6 -> "Weekday";
            default -> throw new IllegalStateException("Invalid day: " + dayOfWeek);
        };


    }
}

