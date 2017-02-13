package com.chtuqu.ch12;

import java.time.*;
import java.time.temporal.ChronoUnit;

public class InstantDurationPeriodTest {
    public static void main(String[] args) {
        testInstant();
        testDuration();
        testPeriod();
    }

    private static void testInstant() {
        Instant now = Instant.now();
        long epochSeconds = now.getEpochSecond();

        Instant thirdSecondFromEpoch;
        // all of the following yield the same result
        thirdSecondFromEpoch = Instant.ofEpochSecond(3);
        thirdSecondFromEpoch = Instant.ofEpochSecond(3, 0);
        thirdSecondFromEpoch = Instant.ofEpochSecond(2, 1_000_000_000);
        thirdSecondFromEpoch = Instant.ofEpochSecond(4, -1_000_000_000);
    }

    private static void testDuration() {
        // prepare a bunch of date-time objects
        LocalTime time1 = LocalTime.of(15, 20, 38);
        LocalTime time2 = LocalTime.of(21, 8, 49);

        LocalDateTime dateTime1 = time1.atDate(LocalDate.of(2014, 5, 27));
        LocalDateTime dateTime2 = time2.atDate(LocalDate.of(2015, 9, 15));

        Instant i1 = Instant.ofEpochSecond(1_000_000_000);
        Instant i2 = Instant.now();

        // create duration between two points
        Duration d1 = Duration.between(time1, time2);
        Duration d2 = Duration.between(dateTime1, dateTime2);
        Duration d3 = Duration.between(i1, i2);
        Duration d4 = Duration.between(time1, dateTime2);

        // create duration from some random value
        Duration threeMinutes;
        threeMinutes = Duration.ofMinutes(3);
        threeMinutes = Duration.of(3, ChronoUnit.MINUTES);
    }

    private static void testPeriod() {
        Period tendays = Period.ofDays(10);
        Period threeWeeks = Period.ofWeeks(3);
        Period twoYearsSixMonthsOneDay = Period.of(2, 6, 1);
    }
}
