package com.chtuqu.ch12;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.util.Locale;

public class FormattingAndParsing {

    private static LocalDate DATE = LocalDate.of(2014, 3, 18);

    public static void main(String[] args) {
        // try formatting dates with default formatters
        testFormattingAndParsing(DateTimeFormatter.BASIC_ISO_DATE); // 20140318
        testFormattingAndParsing(DateTimeFormatter.ISO_LOCAL_DATE); // 2014-03-18

        // try using custom formatter
        DateTimeFormatter customFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        testFormattingAndParsing(customFormatter);

        // try using localized formatter
        DateTimeFormatter italianFormatter = DateTimeFormatter.ofPattern("d. MMMM yyyy", Locale.ITALIAN);
        testFormattingAndParsing(italianFormatter);

        // try creating custom formatter
        DateTimeFormatter customItalianFormatter = new DateTimeFormatterBuilder()
                .appendText(ChronoField.DAY_OF_MONTH)
                .appendLiteral(". ")
                .appendText(ChronoField.MONTH_OF_YEAR)
                .appendLiteral(" ")
                .appendText(ChronoField.YEAR)
                .parseCaseInsensitive()
                .toFormatter(Locale.ITALIAN);
        testFormattingAndParsing(customItalianFormatter);
    }

    private static void testFormattingAndParsing(DateTimeFormatter formatter) {
        String formatted = DATE.format(formatter);
        DATE = LocalDate.parse(formatted, formatter);
    }
}