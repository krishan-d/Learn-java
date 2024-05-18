package com.learning._2_basics_and_oops._1_variables_and_operators;

public class Operators {
    public static void main(String[] args) {

        int a = 10;
        int b = 5;
        int c = 20;
        /*
        Types:
        Arithmetic operators:
        +	Addition
        -	Subtraction
        *	Multiplication
        /	Division
        %	Modulo Operation (Remainder after division)
        */

        System.out.println(10 * 10 / 5 + 3 - 1 * 4 / 2);

        /*
        Assignment operators:
        =	a = b;	a = b;
        +=	a += b;	a = a + b;
        -=	a -= b;	a = a - b;
        *=	a *= b;	a = a * b;
        /=	a /= b;	a = a / b;
        %=	a %= b;	a = a % b;
        */
        short s0 = 10;
        short s1 = 10;
        //s1 = s1 + s0; //CTE because 10 + 10 is now int
        s1 += s0; //Internally fine
        System.out.println(s1); //20

        /*
        Relational operators:
        ==	Is Equal To
        !=	Not Equal To
        >	Greater Than
        <	Less Than
        >=	Greater Than or Equal To
        <=	Less Than or Equal To
        */

        /*
        Logical operators:
        && (AND) (0*0=0,0*1=0,1*0=0,1*1=1)
        || (OR) (0+0=0,0+1=1,1+0=1,1+1=1)
        ! (NOT)
        */
        System.out.println(a < b && a++ < c);//false && true = false
        System.out.println(a);//10 because second condition is not checked
        System.out.println(a < b & a++ < c);//false && true = false
        System.out.println(a);//11 because second condition is checked


        a = 10;
        //|| vs |
        System.out.println(a > b || a++ < c);//true || true = true
        System.out.println(a);//10 because second condition is not checked
        System.out.println(a > b | a++ < c);//true | true = true
        System.out.println(a);//11 because second condition is checked

        /*
        Unary operators:
        +	Unary plus: not necessary to use since numbers are positive without using it
        -	Unary minus: inverts the sign of an expression
        ++	Increment operator: increments value by 1
        --	Decrement operator: decrements value by 1
        !	Logical complement operator: inverts the value of a boolean
        */
        int x = 10;
        System.out.println(x++); //10 (11)
        System.out.println(++x); //12
        System.out.println(x--); //12 (11)
        System.out.println(--x); //10

        int y = 10;
        System.out.println(x++ + ++x); //10+12=22
        System.out.println(y++ + y++); //10+11=21

        int z = -10;
        boolean b0 = true;
        boolean b1 = false;
        System.out.println(~x); //-11 (minus of total positive value which starts from 0)
        System.out.println(~z); //9 (positive of total minus, positive starts from 0)
        System.out.println(!b0); //false (opposite of boolean value)
        System.out.println(!b1); //true

        /*
        Bitwise operators: Perform operation on individual bits.
        ~	Bitwise Complement(0->1 And 1->0)
        <<	Left Shift : [x << y = x * 2^y ]
        >>	Right Shift : [x >> y = x / 2^y ]
        >>>	Unsigned Right Shift
        &	Bitwise AND
        ^	Bitwise exclusive OR
        |   Bitwise inclusive OR
        */
        System.out.println(10 << 2); //10*2^2=10*4=40
        // 20 >> 2 == 20 >>> 2
        //For negative numbers:
        System.out.println(-20 >> 2); //-5
        System.out.println(-20 >>> 2); //1073741819


        // Others...
        // instanceof operator:
        String s = "Hi";
        System.out.println(s instanceof String);

        // Ternary operator:
        int i = 2;
        String res = (i % 2 == 0) ? "Even" : "Odd";
        System.out.print(res);

    }
}
