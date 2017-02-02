package com.chtuqu.ch2.formatter.impl;

import com.chtuqu.ch2.dto.Apple;
import com.chtuqu.ch2.formatter.AppleFormatter;

public class AppleSimpleFormatter implements AppleFormatter {
    @Override
    public String format(Apple apple) {
        return "An apple of " + apple.getWeight() + "g";
    }
}
