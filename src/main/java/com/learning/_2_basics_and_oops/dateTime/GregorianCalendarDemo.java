package com.learning._2_basics_and_oops.dateTime;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class GregorianCalendarDemo {

    public static void main(String[] args) {

        String months[] = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep",
                "Oct", "Nov", "Dec"};

        int year;
        // Create a Gregorian calendar initialized
        // with the current date and time in the
        // default locale and timezone.

        GregorianCalendar calendar = new GregorianCalendar();

        // Display current time and date information.
        System.out.print("Date: ");
        System.out.print(months[calendar.get(Calendar.MONTH)] + "\s");
        System.out.print(calendar.get(Calendar.DATE) + "\s");
        System.out.println(year = calendar.get(Calendar.YEAR));
        System.out.print("Time: ");
        System.out.print(calendar.get(Calendar.HOUR) + ":");
        System.out.print(calendar.get(Calendar.MINUTE) + ":");
        System.out.println(calendar.get(Calendar.SECOND));


        if (calendar.isLeapYear(year)) System.out.println("The current year is leap year!");
    }
}
