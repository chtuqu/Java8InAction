package com.chtuqu.ch12;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjuster;

public class NextWorkingDay implements TemporalAdjuster {

    public static void main(String[] args) {
        LocalDate current = LocalDate.now();

        for (int i = 0; i < 7; i++) {
            System.out.print("The next working day after " + current.getDayOfWeek());
            current = current.with(new NextWorkingDay());
            System.out.println(" is " + current.getDayOfWeek() + ".");
        }
    }

    @Override
    public Temporal adjustInto(Temporal temporal) {
        DayOfWeek dayOfWeek = DayOfWeek.of(temporal.get(ChronoField.DAY_OF_WEEK));
        int daysToAdd = 0;
        switch (dayOfWeek) {
            case MONDAY:
            case TUESDAY:
            case WEDNESDAY:
            case THURSDAY:
                daysToAdd = 1;
                break;
            case FRIDAY:
            case SATURDAY:
            case SUNDAY:
                daysToAdd = 8 - dayOfWeek.getValue();
        }
        return temporal.plus(daysToAdd, ChronoUnit.DAYS);
    }
}
