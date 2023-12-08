package com.learning._8.api_Time;

import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;

public class Basics {

    public static void main(String[] args) {

        Instant instant = Instant.now();
        System.out.println(instant);


        LocalDate date = LocalDate.of(2023, 10, 27);
        // Features and operations:
        // 1. Immutable:

        // 2. Date Arithmetic
        LocalDate tomorrow = date.plusDays(1);
        LocalDate nextMonth = date.plusMonths(1);
        LocalDate nextYear = date.plusYears(1);

        // 3. Date Comparison
        LocalDate today = LocalDate.now();
        System.out.println(date.isEqual(today) + " | isPast: " + date.isBefore(today) + " | isFuture: "+ date.isAfter(today));

        // 4. Formatting and Parsing:
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formattedDate = date.format(formatter);
        System.out.println("formattedDate: " + formattedDate);
        LocalDate parsedDate = LocalDate.parse("2023-10-27", formatter);

        // 5. Date Adjusters:
        LocalDate firstDayOfMonth = date.with(TemporalAdjusters.firstDayOfMonth());
        LocalDate nextWednesday = date.with(TemporalAdjusters.next(DayOfWeek.WEDNESDAY));


        int year = date.getYear();
        Month month = date.getMonth();
        int dayOfMonth = date.getDayOfMonth();
        boolean isLeapYear = date.isLeapYear();


    }
}
