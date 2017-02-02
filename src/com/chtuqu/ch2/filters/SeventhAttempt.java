package com.chtuqu.ch2.filters;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class SeventhAttempt {
    public static <T> List<T> filter(List<T> inventory, Predicate<T> p) {
        List<T> result = new ArrayList<>();
        for (T t : inventory) {
            if (p.test(t)) {
                result.add(t);
            }
        }
        return result;
    }
}
