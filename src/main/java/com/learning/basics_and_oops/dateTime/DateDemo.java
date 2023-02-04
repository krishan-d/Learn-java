package com.learning.basics_and_oops.dateTime;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateDemo {

    public static void main(String[] args) throws ParseException {

        //Current date time
        Date dNow = new Date();
        //Formatting date
        SimpleDateFormat sdf = new SimpleDateFormat("E yyyy-MM-dd hh:mm:ss a zzz");
        String d = sdf.format(dNow);
        System.out.println("Current Date: " + d);

        //or
        //By using System.out.printf
        System.out.printf("Current Date/Time : %tc \n", dNow);

        //Parsing date string into Date object
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        String input = "1818-10-12";
        Date parsedDate = sf.parse(input);
        System.out.println("Parsed Date: " + parsedDate);
    }
}
