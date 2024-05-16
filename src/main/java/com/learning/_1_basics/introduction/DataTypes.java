package com.learning._1_basics.introduction;

public class DataTypes {

    public static void main(String[] args) {

        /*
        1. Primitive Data Type:

        The minimum value, when underflow, wraps around to the maximum value and continue processing.
        The maximum value, when underflow, wraps around to the minimum value and continue processing.

        boolean: 1-bit [true || false(default)]
        byte: 8-bit [range: [-2^7, 2^7 - 1] || [-128, 127]] (default value = 0)
        short : 16-bit [range: [-2^15, 2^15 - 1]] (default value = 0)
        int : 32-bit signed 2's complement integer. [-2^31, 2^31-1] (default value = 0)/ DEFAULT NUMBER HOLD BY JAVA
        Note: Integer class to use int as an unsigned integer. [0, 2^32 - 1]

        long : 64-bit [-2^63, 2^63-1] (default value = 0L)
        Note: Long class to use long as an unsigned long.[0, 2^64 - 1]

        float : single precision 32-bit floating point. (default value = 0.0F)
        a. Used to save memory in large arrays of floating point numbers instead of long.
        b. Never be used for precise value such as currency. For that use java.math.BigDecimal class instead.
s
        double : double-precision 64-bit floating point. (default value = 0.0D || 0.0d)
        Note: DEFAULT CHOICE FOR DECIMAL VALUES. And should never be used for precise values.

        char : single 16-bit unicode character. ['\u0000'(|| 0), '\uFFFF'(|| 65535)] (default value = '\u0000')

        2. Non-primitive Data Type:
        Classes, interface, Array...
        String||any object: (default value= null) */

        // Literals...
        boolean res = true;

        char capitalC = 'C';
        char c = 'a';
        // NOTE: Escape sequences can be used as character literals. such as \b \t \n \f \r \" \' \\

        byte b = 100;
        byte myMinByte = Byte.MIN_VALUE, myMaxByte = Byte.MAX_VALUE;
        byte nybbles = 0b0010_0101;

        short s = 10000;
        short myMinShort = Short.MIN_VALUE, myMaxShort = Short.MAX_VALUE;

        int i = 100000;
        int decNum = 26;
        int hexNum = 0x1a;
        int binNum = 0b11010;
        int minIntValue = Integer.MIN_VALUE;
        int maxIntValue = Integer.MAX_VALUE;
        System.out.println(minIntValue + " | Busted min value: " + (minIntValue - 1)); //underflow
        System.out.println(maxIntValue + " | Busted max value: " + (maxIntValue + 1)); //overflow


        // Underscore characters in numeric Literals:
        long myLongValue = 2_123_456_780;
//      long myLongValueLarge = 2_123_456_780_234;
        // NOTE: A numerical literal that exceeds Integer.MAX_VALUE, must use 'L' suffix. otherwise will get
        // error 'Integer number too large'.
        long myLongValueLarge = 2_123_456_780_234L;

        long creditCardNumber = 1234_5678_9012_3456L;
        long socialSecurityNumber = 999_99_9999L;
        long hexBytes = 0xFF_EC_DE_5E;
        long hexWords = 0xCAFE_BABE;
        long maxLong = 0x7fff_ffff_ffff_ffffL;
        long bytes = 0b11010010_01101001_10010100_10010010;
        long myLongSize = Long.SIZE; // 64


        float f = 123.4F;
        float pi = 3.14_15F;
        float myMinFloat = Float.MIN_VALUE; // 1.4E-45  == 1.4 x 10^-45
        float myMaxFloat = Float.MAX_VALUE; // 3.4028235E38  == 3.4028235 x 10^38
//      float myFloatNumber = 5.25; // Error without F suffix because by default is a double value
        float myFloatNumber = 5.25F;
//      float myFloatNumber = (float)5.25; // Type casting, NOT RECOMMENDED

        double d1 = 123.4;
        double d2 = 1.234e2; // same value as d1, but in scientific notation
        System.out.println(Double.MIN_VALUE + " | " + Double.MAX_VALUE);
        double myMinDouble = Double.MIN_VALUE; // 4.9E-324 == 4.9 * 10^-324
        double myMaxDouble = Double.MAX_VALUE; // 1.7976931348623157E308 == 1.79 * 10^308
        // NOTE: double is more precise than float, and default type for floating point numbers in java.
        float myFloatValue = 5.0F / 3.0F; // 1.6666666
        double myDoubleValue = 5.0 / 3.0; // 1.6666666666666667
        System.out.println(myDoubleValue + " | " + myFloatValue);

        System.out.println(Math.min(Double.MIN_VALUE, 0.0d)); // 0.0 ??
        System.out.println(0.1 * 3); // 0.30000000000000004 ??
        System.out.println(0.1 * 2); // 0.2
        // NOTE: In java, only the floating numbers that are powers of 2 are represented accurately by binary representation.
        // The rest of the numbers should be rounded to accommodate(provide sufficient space for) the limited bits as required.


        // Type casting:
        // casting means to treat or convert a number, from one type to another.
        int myNewInt = (minIntValue / 2);
        // This statement works because the result is an int and assigning it to a int variable is fine.
        // byte byteTotal = (myMinByte / 2); // Error
        // This statement doesn't work because expression (myMinByte / 2) is an int and an int can't be assigned to a short.
        // because compiler won't guess the result.
        short myNewShort = (-128 / 2);
        // This expression works because result of (-128/2) is an int, but when calculations use only literal values,
        // the compiler can determine the result immediately, and knows the value fits into short.
        short myNewShort1 = (short) (myMinShort / 2); //casting

        byte b1 = 100;
        short s1 = 24804;
        int i1 = 806410;
        long l1 = 50000L + 10L * (b1 + s1 + i1);
        System.out.println(l1);


        /*
        Invalid underscores:
        1. At the beginning or end of a number.
        2. Adjacent to a decimal point in a floating point literal.
        3. Prior to an F or L suffix.
        4. In positions where a string of digits is expected.
        */

        // String:
        // String are objects, non-primitive type.

        //Unicode System:
        //Universal International Standard Character Encoding
        //In unicode, character holds 2 bytes, so java also uses 2 byte for characters.
        //Lowest value: \u0000
        //Highest value: \uFFFF

    }
}
