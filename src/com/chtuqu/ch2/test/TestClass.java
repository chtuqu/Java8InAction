package com.chtuqu.ch2.test;

import com.chtuqu.ch2.dto.Apple;
import com.chtuqu.ch2.filters.*;
import com.chtuqu.ch2.predicate.ApplePredicate;
import com.chtuqu.ch2.predicate.impl.AppleGreenColorPredicate;

import java.util.Arrays;
import java.util.List;

public class TestClass {
    public static void main(String[] args) {
        List<Apple> inventory = Arrays.asList(  new Apple(80, "green"),
                                                new Apple(155, "green"),
                                                new Apple(120, "red")   );

        List<Apple> result = null;

//        result = firstAttempt(inventory);
//        result = secondAttempt(inventory);
//        result = thirdAttempt(inventory);
//        result = fourthAttempt(inventory);
//        result = fifthAttempt(inventory);
//        result = sixthAttempt(inventory);
//        result = seventhAttempt(inventory);

        System.out.println(result);
    }

    public static List<Apple> firstAttempt(List<Apple> inventory) {
        return FirstAttempt.filterGreenApples(inventory);
    }

    public static List<Apple> secondAttempt(List<Apple> inventory) {
        return SecondAttempt.filterApples(inventory, "green");
    }

    public static List<Apple> thirdAttempt(List<Apple> inventory) {
        return ThirdAttempt.filterApples(inventory, "green", 0, true);
        // return ThirdAttempt.filterApples(inventory, "", 150, false);
    }

    public static List<Apple> fourthAttempt(List<Apple> inventory) {
        return FourthAttempt.filterApples(inventory, new AppleGreenColorPredicate());
        // FourthAttempt.filterApples(inventory, new AppleHeavyWeightPredicate());
    }

    public static List<Apple> fifthAttempt(List<Apple> inventory) {
        return FourthAttempt.filterApples(inventory, new ApplePredicate() {
            @Override
            public boolean test(Apple apple) {
                return "green".equals(apple.getColor());
            }
        });
    }

    public static List<Apple> sixthAttempt(List<Apple> inventory) {
        return FourthAttempt.filterApples(inventory, (Apple apple) -> "green".equals(apple.getColor()));
    }

    public static List<Apple> seventhAttempt(List<Apple> inventory) {
        return SeventhAttempt.filter(inventory, (Apple apple) -> "green".equals(apple.getColor()));
    }
}