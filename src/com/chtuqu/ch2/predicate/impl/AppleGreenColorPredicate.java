package com.chtuqu.ch2.predicate.impl;

import com.chtuqu.ch2.dto.Apple;
import com.chtuqu.ch2.predicate.ApplePredicate;

public class AppleGreenColorPredicate implements ApplePredicate {
    @Override
    public boolean test(Apple apple) {
        return "green".equals(apple.getColor());
    }
}
