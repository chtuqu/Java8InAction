package com.chtuqu.ch2.predicate.impl;

import com.chtuqu.ch2.dto.Apple;
import com.chtuqu.ch2.predicate.ApplePredicate;

public class AppleHeavyWeightPredicate implements ApplePredicate {
    @Override
    public boolean test(Apple apple) {
        return apple.getWeight() > 150;
    }
}
