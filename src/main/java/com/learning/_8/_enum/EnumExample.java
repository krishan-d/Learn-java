package com.learning._8._enum;

import java.util.Arrays;
import java.util.Objects;

/*
 * enum:
 * Enum is a special class/data type that enables for a variable to be a set of predefined constants.
 * The variable must be equal to one of the predefined values.
 *
 * Note: enum extends Enum class internally. i.e. it doesn't extend other classes. however enum can implement interfaces
 * */
enum Compass {
    NORTH, SOUTH(6), EAST, WEST(9);

    //method and data members
    int angle;
    public int getValue() { return angle; }

    //constructor
    Compass() {
        angle = 12; //default angle
        System.out.println("Enum constructor");
    }

    Compass(int a) {
        angle = a;
    }
}

//Enum INTERNAL WORKING/ BEHIND PICTURE: Enum creates a class internally
/*
* class Compass {
*     static final Compass NORTH = new Compass();
*     static final Compass SOUTH = new Compass();
*     static final Compass EAST = new Compass();
*     static final Compass WEST = new Compass();
* }
* */


enum Days {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY;
}

/*
 * The compiler will generate a class roughly equivalent to the following:
 */
/*public final class Days extends java.lang.Enum<Days> {
    // Enum constants
    public static final Days MONDAY = new Days("MONDAY", 0);
    public static final Days TUESDAY = new Days("TUESDAY", 1);
    public static final Days WEDNESDAY = new Days("WEDNESDAY", 2);
    public static final Days THURSDAY = new Days("THURSDAY", 3);
    public static final Days FRIDAY = new Days("FRIDAY", 4);
    public static final Days SATURDAY = new Days("SATURDAY", 5);
    public static final Days SUNDAY = new Days("SUNDAY", 6);

    // Private constructor
    private Days(String name, int ordinal) {
        super(name, ordinal);
    }

    // Array of all constants
    private static final Days[] VALUES = { MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY };

    // Static method to get all values
    public static Days[] values() {
        return VALUES.clone();
    }

    // Static method to get a specific value by name
    public static Days valueOf(String name) {
        for (Days d : VALUES) {
            if (d.name().equals(name)) {
                return d;
            }
        }
        throw new IllegalArgumentException("No enum constant Days." + name);
    }
}*/

public class EnumExample {
    //Enum inside class
    public static void main(String[] args) {
        System.out.println(Compass.NORTH);

        Compass c = Compass.SOUTH;
        switch (Objects.requireNonNull(c)) {
            case SOUTH -> System.out.println("South Direction !");
            case NORTH -> System.out.println("North Direction !");
        }

        System.out.println(Compass.NORTH.getValue()); // 12
        System.out.println(Compass.SOUTH.getValue()); // 6

        //ordinals
        System.out.println("North ordinal: " + Compass.NORTH.ordinal());   // 0

        //values
        Compass com[] = Compass.values(); //values()  is given by Jvm or compiler
        System.out.println("Enum Array/Collection: " + Arrays.toString(com));
        //Enum Array/Collection: [NORTH, SOUTH, EAST, WEST]
        for (Compass dir : com) System.out.println(dir);
    }
}