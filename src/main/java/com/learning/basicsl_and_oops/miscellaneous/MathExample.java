package com.learning.basicsl_and_oops.miscellaneous;

public class MathExample {

    public static void main(String[] args) {

        double x = 10;
        double y = 4;

        System.out.println("max(10, 4): " + Math.max(x, y));

        System.out.println("pow(10, 2) : " + Math.pow(x, 2));

        System.out.println("log(10) : " + Math.log(x));

        System.out.println("log10(10) = " + Math.log10(x));

        System.out.println("exp(10) = " + Math.exp(x));

        double z = 30;
        double radian = Math.toRadians(z);
        double degree = Math.toDegrees(radian);
        System.out.println("Radian: " + radian + " Degree: " + degree);

        double sin = Math.sin(z);
        double sinInverse = Math.asin(sin);
        System.out.println("sin: " + sin + " sin inverse: " + sinInverse);
        System.out.println("sin hyperbolic: " + Math.sinh(z));

        double random = Math.random();
        System.out.println("random : " + random);

    }
}
