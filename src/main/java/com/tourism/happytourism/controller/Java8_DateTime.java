package com.tourism.happytourism.controller;


import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.temporal.ChronoUnit;

public class Java8_DateTime {

    public static void main(String[] args) {

        /*
        LocalDate   : from java.time package
                       Without having  time
                       having so many in built methods,
                       like to get current Date, year, month, dayOfWeek and manipulation we can do
         */

        // to get current date
        LocalDate localDate = LocalDate.now();
        int year = LocalDate.now().getYear();
        Month month = LocalDate.now().getMonth();
        DayOfWeek dayOfWeek = LocalDate.now().getDayOfWeek();

        System.out.println("Local Date : " + localDate);
        System.out.println("Year       : " + year);
        System.out.println("Month      : " + month);
        System.out.println("Day        : " + dayOfWeek);


        // To convert string date to LocalDate, note:- format must be 'yyyy-MM-dd'
        LocalDate stringToDate = LocalDate.parse("2023-02-23");
        LocalDate valuesToLocalDate = LocalDate.of(2000, 8, 01);

        System.out.println("\nParsing String Date to LocalDate       : " + stringToDate);
        System.out.println("Parsing Int Values to LocalDate       : " + valuesToLocalDate);


        LocalDate tomorrow = LocalDate.now().plusDays(1);
        LocalDate previousMonthSameDay = LocalDate.now().minus(1, ChronoUnit.MONTHS);

        System.out.println("\nTomorrow                : " + tomorrow);
        System.out.println("Previous Month Same Day   : " + previousMonthSameDay);


        boolean notBefore = LocalDate.parse("2016-06-12")
                .isBefore(LocalDate.parse("2016-06-11"));

        boolean isAfter = LocalDate.parse("2016-06-12")
                .isAfter(LocalDate.parse("2016-06-11"));

        System.out.println("\nFirst date is before       : " + notBefore);
        System.out.println("First date is after        : " + isAfter);



          /*
        LocalTime   : from java.time package
                       Without having  Date
                       having so many in built methods,
                       like to get hou, sec,   and manipulation we can do
         */

        // to get current time
        LocalTime  localTime = LocalTime.now();
        System.out.println( "Current Time    :"+ localTime);

        // parsing  String time into localTime
        LocalTime   stringToTime = LocalTime.parse("10:30");
        LocalTime   valuesToTime = LocalTime.of(10,30);
        System.out.println("String to Time   : " + stringToTime);
        System.out.println("Values to Time   : " + valuesToTime);


        //parsing a string and adding an hour
        LocalTime sevenThirty = LocalTime.parse("06:30").plus(1, ChronoUnit.HOURS);
        System.out.println("parsing a string and adding an hour   : " + sevenThirty);


        int hour = LocalTime.parse("08:30").getHour();
        System.out.println("Hour from Time   : " + hour);


        int min = LocalTime.parse("08:30").getMinute();
        System.out.println("sec from Time   : " + min);

        boolean isbefore = LocalTime.parse("06:30").isBefore(LocalTime.parse("07:30"));
        boolean isafter = LocalTime.parse("06:30").isAfter(LocalTime.parse("07:30"));
        System.out.println("isbefore   : " + isbefore);
        System.out.println("isafter   : " + isafter);

    }
}
