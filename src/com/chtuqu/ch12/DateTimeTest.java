package com.chtuqu.ch12;

import java.time.*;
import java.time.temporal.ChronoField;

public class DateTimeTest {
    public static void main(String[] args) {
        LocalDate date = testLocalDate();
        LocalTime time = testLocalTime();
        testLocalDateTime(date, time);
    }

    private static LocalDate testLocalDate() {
        LocalDate date = LocalDate.of(2014, 3, 18); // obtain LocalDate from specific date with static factory method
        LocalDate now = LocalDate.now(); // or from the current date point

        // read data with built-in getter methods
        int year = date.getYear();
        Month month = date.getMonth();
        int day = date.getDayOfMonth();
        DayOfWeek dow = date.getDayOfWeek();
        int len = date.lengthOfMonth();
        boolean leap = date.isLeapYear();

        // or by passing a TemporalField to get()
        year = date.get(ChronoField.YEAR);
        int monthNumeric = date.get(ChronoField.MONTH_OF_YEAR);
        day = date.get(ChronoField.DAY_OF_MONTH);
        int dowNumeric = date.get(ChronoField.DAY_OF_WEEK);

        LocalDate parsedDate = LocalDate.parse("2014-03-18"); // throws runtime java.time.format.DateTimeParseException
        return parsedDate;
    }

    private static LocalTime testLocalTime() {
        LocalTime time = LocalTime.of(13, 45, 20); // obtain LocalTime from specific time with static factory method
        LocalTime now = LocalTime.now(); // or from the current time point

        // read time with built-in getter methods
        int hour = time.getHour();
        int minute = time.getMinute();
        int second = time.getSecond();

        // or by passing a TemporalField to get()
        hour = time.get(ChronoField.HOUR_OF_DAY);
        minute = time.get(ChronoField.MINUTE_OF_HOUR);
        second = time.get(ChronoField.SECOND_OF_MINUTE);

        LocalTime parsedTime = LocalTime.parse("13:45:20");
        return parsedTime;
    }

    private static void testLocalDateTime(LocalDate date, LocalTime time) {
        LocalDateTime dt1 = LocalDateTime.of(2014, 3, 18, 13, 45, 20); // create from specific point
        LocalDateTime dt2 = LocalDateTime.of(date, time); // combine date and time
        LocalDateTime dt3 = date.atTime(13, 45, 20); // derive from date
        LocalDateTime dt4 = date.atTime(time); // derive from date
        LocalDateTime dt5 = time.atDate(date); // derive from time

        LocalDate date1 = dt1.toLocalDate(); // extract date component
        LocalTime time1 = dt1.toLocalTime(); // extract time component
    }
}
