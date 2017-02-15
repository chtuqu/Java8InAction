package com.chtuqu.ch12;

import java.time.chrono.HijrahDate;
import java.time.chrono.IsoChronology;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAdjusters;

public class AlternativeCalendar {

    public static void main(String[] args) {
        HijrahDate ramadanDate = HijrahDate.now()
                .with(ChronoField.DAY_OF_MONTH, 1)
                .with(ChronoField.MONTH_OF_YEAR, 9);

        System.out.println("Ramadan starts on " + IsoChronology.INSTANCE.date(ramadanDate) + " and ends on " +
                                        IsoChronology.INSTANCE.date(ramadanDate.with(TemporalAdjusters.lastDayOfMonth())));
    }

}
