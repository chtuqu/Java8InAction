package com.chtuqu.ch2.filters;

import com.chtuqu.ch2.dto.Apple;

import java.util.ArrayList;
import java.util.List;

public class SecondAttempt {
    public static List<Apple> filterApples(List<Apple> inventory, String color) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (apple.getColor().equals(color)) {
                result.add(apple);
            }
        }
        return result;
    }
}
