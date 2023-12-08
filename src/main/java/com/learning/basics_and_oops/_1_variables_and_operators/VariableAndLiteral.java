package com.learning.basics_and_oops._1_variables_and_operators;

public class VariableAndLiteral {
    public static void main(String[] args) {
        // Variable is a location in memory to hold data. Each variable have a unique name(identifier).
        int speed = 100;

        // Start with Letter/Underscore/dollar.
        // No whitespace

        // Types:
        // Instance variables(Non-static)
        // Class variables(static)
        // Local variables
        // Parameters

        // Literals...
        // data used for representing fixed values.

        // Boolean Literals
        boolean b = true;

        // Integer Literals
        // Types:
        // binary (base 2)
        // decimal (base 10)
        // octal (base 8) [0b|0B]
        // hexadecimal (base 16) [0x|0X]

        int binaryNum = 0b0010;
        int octNum = 027;
        int decNum = 34;
        int hexNum = 0x2F;
        int binNum = 0b10010;
        System.out.println(hexNum + "|" + decNum + "|" + octNum + "|" + binNum);

        // Floating-point Literals
        double d = 3.4;
        float f = 3.4F;

        double dScientific = 3.445e2;  // 3.445*10^2
        System.out.println(d + "|" + f + "|" + dScientific);

        // Character Literals
        char character = 'a';
        // Escape sequences can be used as character literals. such as \b, \t, \n
        char c = '\b';

        // String Literals
        String msg = "Hi";

    }
}
