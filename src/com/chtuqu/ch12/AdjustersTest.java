package com.chtuqu.ch12;

import java.time.DayOfWeek;
import java.time.LocalDate;

import static java.time.temporal.TemporalAdjusters.*;

public class AdjustersTest {
    public static void main(String[] args) {
        testAdjusters();
    }

    private static void testAdjusters() {
        LocalDate date = LocalDate.of(2017, 2, 15);          // 15.02.2017

        LocalDate modifiedDate;
        // WARNING: LocalDate is immutable, normally the result of method call should be (re)assigned to the variable
        // Assigned to a different variable here to keep initial date consistent across invocations.
        modifiedDate = date.with(dayOfWeekInMonth(2, DayOfWeek.MONDAY));    // 13.02.2017
        modifiedDate = date.with(firstDayOfMonth());                        // 01.02.2017
        modifiedDate = date.with(firstDayOfNextMonth());                    // 01.03.2017
        modifiedDate = date.with(firstDayOfNextYear());                     // 01.01.2018
        modifiedDate = date.with(firstDayOfYear());                         // 01.01.2017
        modifiedDate = date.with(firstInMonth(DayOfWeek.SATURDAY));         // 04.02.2017
        modifiedDate = date.with(lastDayOfMonth());                         // 28.02.2017
        modifiedDate = date.with(lastDayOfYear());                          // 31.12.2017
        modifiedDate = date.with(lastInMonth(DayOfWeek.MONDAY));            // 27.02.2017
        modifiedDate = date.with(next(DayOfWeek.SUNDAY));                   // 19.02.2017
        modifiedDate = date.with(previous(DayOfWeek.FRIDAY));               // 10.02.2017
        modifiedDate = date.with(nextOrSame(DayOfWeek.WEDNESDAY));          // 15.02.2017
        modifiedDate = date.with(previousOrSame(DayOfWeek.THURSDAY));       // 09.02.2017
    }
}
