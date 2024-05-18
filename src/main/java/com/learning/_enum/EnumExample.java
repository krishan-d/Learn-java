package com.learning._enum;

import java.util.Objects;

/*
 * enum:
 * Enum is a special data type that enables for a variable to be a set of predefined constants.
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

public class EnumExample {
    //Enum inside class
    enum Days {
        MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY;
    }
    public static void main(String[] args) {
        System.out.println(Compass.NORTH);

        Compass c = Compass.SOUTH;
        switch (Objects.requireNonNull(c)) {
            case SOUTH -> System.out.println("South Direction !");
            case NORTH -> System.out.println("North Direction !");
        }

        System.out.println(Compass.NORTH.getValue());
        System.out.println(Compass.SOUTH.getValue());

        //ordinals
        System.out.println("North ordinal: " + Compass.NORTH.ordinal());

        //values
        Compass com[] = Compass.values(); //values()  is given by Jvm or compiler
        System.out.println("Enum Array/Collection: " + com);
        for (Compass dir : com) System.out.println(dir);
    }
}
