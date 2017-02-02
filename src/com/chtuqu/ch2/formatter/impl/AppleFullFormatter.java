package com.chtuqu.ch2.formatter.impl;

import com.chtuqu.ch2.dto.Apple;
import com.chtuqu.ch2.formatter.AppleFormatter;

public class AppleFullFormatter implements AppleFormatter {
    @Override
    public String format(Apple apple) {
        return "A " + apple.getColor() + " apple of " + apple.getWeight() + "g";
    }
}
