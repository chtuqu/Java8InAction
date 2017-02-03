package com.chtuqu.ch6;

import com.chtuqu.ch4.DishMenu;
import com.chtuqu.ch4.dto.Dish;

import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Optional;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.*;

public class SummarizingCollectors {
    public static void main(String[] args) {
        List<Dish> menu = DishMenu.menu;

        // How many dishes?
        long dishCount;
        dishCount = menu.stream().count(); // count with Stream
        dishCount = menu.stream().collect(counting()); // count with Collector

        // What is the highest/lowest calorie dish?
        Optional<Dish> highestCalorieDish = menu.stream().collect(maxBy(comparing(Dish::getCalories)));
        Optional<Dish> lowestCalorieDish = menu.stream().collect(minBy(comparing(Dish::getCalories)));
        highestCalorieDish = menu.stream().reduce((d1, d2) -> d1.getCalories() > d2.getCalories() ? d1 : d2); // dirty
        lowestCalorieDish = menu.stream().reduce((d1, d2) -> d1.getCalories() < d2.getCalories() ? d1 : d2); // dirty

        // Total amount of calories in the menu?
        int totalCalories;
        totalCalories = menu.stream().mapToInt(Dish::getCalories).sum(); // sum with IntStream
        totalCalories = menu.stream().collect(summingInt(Dish::getCalories)); // sum with summingInt Collector
        totalCalories = menu.stream().collect(reducing(0, Dish::getCalories, (i, j) -> i+j)); // dirty

        // Average number of calories in a dish?
        double average;
        average = menu.stream().mapToInt(Dish::getCalories).average().getAsDouble(); // average with IntStream
        average = menu.stream().collect(averagingInt(Dish::getCalories)); // average with Collector

        // What if you want all the stats at once (count, avg, min, max, sum)?
        IntSummaryStatistics stats = menu.stream().collect(summarizingInt(Dish::getCalories));

        // Concatenate names
        String joined1 = menu.stream().map(Dish::getName).collect(joining());
        String joined2 = menu.stream().map(Dish::getName).collect(joining(","));
        String joined3 = menu.stream().map(Dish::getName).collect(joining(",", "PREFIX", "SUFFIX"));
    }
}
