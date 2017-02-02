package com.chtuqu.ch2.formatter;

import com.chtuqu.ch2.dto.Apple;

import java.util.List;

public class ApplePrinter {
    public static void prettyPrintApple(List<Apple> inventory, AppleFormatter formatter) {
        for (Apple apple : inventory) {
            String output = formatter.format(apple);
            System.out.println(output);
        }
    }
}
