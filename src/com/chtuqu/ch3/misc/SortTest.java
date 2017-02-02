package com.chtuqu.ch3.misc;

import com.chtuqu.ch2.dto.Apple;

import java.util.Arrays;
import java.util.List;

import static java.util.Comparator.comparing;

public class SortTest {
    public static void main(String[] args) {
        List<Apple> inventory = Arrays.asList(
                new Apple(9, "green"),
                new Apple(5, "yellow"),
                new Apple(3, "red"));
        System.out.println(inventory);
        inventory.sort(comparing(Apple::getWeight));
        System.out.println(inventory);
        inventory.sort(comparing(Apple::getColor));
        System.out.println(inventory);
    }
}
