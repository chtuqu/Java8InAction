package com.chtuqu.ch2.filters;

import com.chtuqu.ch2.dto.Apple;

import java.util.ArrayList;
import java.util.List;

public class FirstAttempt {
    public static List<Apple> filterGreenApples(List<Apple> inventory) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if ("green".equals(apple.getColor())) {
                result.add(apple);
            }
        }
        return result;
    }
}