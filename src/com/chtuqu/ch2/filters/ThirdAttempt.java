package com.chtuqu.ch2.filters;

import com.chtuqu.ch2.dto.Apple;

import java.util.ArrayList;
import java.util.List;

public class ThirdAttempt {
    public static List<Apple> filterApples(List<Apple> inventory, String color, int weight, boolean flag) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if ( (flag && apple.getColor().equals(color)) ||
                    (!flag && apple.getWeight() == weight)) {
                result.add(apple);
            }
        }
        return result;
    }
}
