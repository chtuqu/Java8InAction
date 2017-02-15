package com.chtuqu.ch12;

import java.time.*;

public class TimeZoneTest {
    public static void main(String[] args) {
        ZoneId romeZone = ZoneId.of("Europe/Rome");

        // create ZonedDateTime from LocalDate at the start of the day
        LocalDate date = LocalDate.of(2014, 3, 18);
        ZonedDateTime zdt1 = date.atStartOfDay(romeZone);

        // create ZonedDateTime from LocalDateTime at the specified point
        LocalDateTime dateTime = LocalDateTime.of(2014, 3, 18, 13, 45);
        ZonedDateTime zdt2 = dateTime.atZone(romeZone);

        // create ZonedDateTime from Instant
        Instant instant = Instant.now();
        ZonedDateTime zdt3 = instant.atZone(romeZone);

        Instant instantFromDateTime = dateTime.toInstant(ZoneOffset.ofHours(2)); // try converting LocalDateTime to Instant...
        LocalDateTime timeFromInstant = LocalDateTime.ofInstant(instant, romeZone); // ...and back

        ZoneOffset newYorkOffset = ZoneOffset.of("-05:00");
        OffsetDateTime dateTimeInNY = OffsetDateTime.of(dateTime, newYorkOffset);
    }
}
