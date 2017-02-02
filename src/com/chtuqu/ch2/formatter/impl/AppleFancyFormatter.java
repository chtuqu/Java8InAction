package com.chtuqu.ch2.formatter.impl;

import com.chtuqu.ch2.dto.Apple;
import com.chtuqu.ch2.formatter.AppleFormatter;

public class AppleFancyFormatter implements AppleFormatter {
    @Override
    public String format(Apple apple) {
        String characteristic = apple.getWeight() > 150 ? "heavy" : "light";
        return "A " + characteristic + " " + apple.getColor() + " apple";
    }
}
