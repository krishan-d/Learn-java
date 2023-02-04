package com.learning.basics.introduction;

public class DataTypes {

    public static void main(String[] args) {

        /*
        Primitive Data Type:

        boolean: 1-bit [true || false(default)]
        byte: 8-bit [range: [-2^7, 2^7 - 1] || [-128, 127]] (default value = 0)
        short : 16-bit [range: [-2^15, 2^15 - 1]] (default value = 0)
        int : 32-bit signed 2's complement integer. [-2^31, 2^31-1] (default value = 0)
        Note: Integer class to use int as an unsigned integer. [0, 2^32 - 1]

        long : 64-bit [-2^63, 2^63-1] (default value = 0L)
        Note: Long class to use long as an unsigned long.[0, 2^64 - 1]

        float : single precision 32-bit floating point. (default value = 0.0F)
        1. Used to save memory in large arrays of floating point numbers instead of long.
        2. Never be used for precise value such as currency. For that use java.math.BigDecimal class instead.

        double : double-precision 64-bit floating point. (default value = 0.0D || 0.0d)
        Note: default choice for decimal values. And should never be used for precise values.

        char : single 16-bit unicode character. ['\u0000'(|| 0), '\uFFFF'(|| 65535)] (default value = '\u0000')

        Non-primitive Data Type:
        Classes, interface, Array...
        String||any object: (default value= null) */

        // Literals...
        boolean res = true;
        char capitalC = 'C';
        byte b = 100;
        short s = 10000;
        int i = 100000;

        int decNum = 26;
        int hexNum = 0x1a;
        int binNum = 0b11010;

        double d1 = 123.4;
        // same value as d1, but in scientific notation
        double d2 = 1.234e2;
        float f = 123.4F;

        char c = 'a';
        // Escape sequences can be used as character literals. such as \b \t \n \f \r \" \' \\

        // Underscore characters in numeric Literals:
        long creditCardNumber = 1234_5678_9012_3456L;
        long socialSecurityNumber = 999_99_9999L;
        float pi = 3.14_15F;
        long hexBytes = 0xFF_EC_DE_5E;
        long hexWords = 0xCAFE_BABE;
        long maxLong = 0x7fff_ffff_ffff_ffffL;

        byte nybbles = 0b0010_0101;
        long bytes = 0b11010010_01101001_10010100_10010010;

        /*
        Invalid underscores:
        1. At the beginning or end of a number.
        2. Adjacent to a decimal point in a floating point literal.
        3. Prior to an F or L suffix.
        4. In positions where a string of digits is expected. */

        // String:
        // String are objects, non-primitive type.

        //Unicode System:
        //Universal International Standard Character Encoding
        //In unicode, character holds 2 bytes, so java also uses 2 byte for characters.
        //Lowest value: \u0000
        //Highest value: \uFFFF




    }
}
