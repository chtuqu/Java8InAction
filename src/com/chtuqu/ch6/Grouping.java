package com.chtuqu.ch6;

import com.chtuqu.ch4.DishMenu;
import com.chtuqu.ch4.dto.Dish;
import com.chtuqu.ch4.dto.CaloricLevel;

import java.util.*;

import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.*;

public class Grouping {
    public static void main(String[] args) {
        List<Dish> menu = DishMenu.menu;

        // ordinary grouping
        Map<Dish.Type, List<Dish>> dishesByType = menu.stream().collect(groupingBy(Dish::getType));
        Map<CaloricLevel, List<Dish>> dishesByCaloricLevel = menu.stream().collect(groupingBy(Grouping::getCaloricLevel));

        // multilevel grouping
        Map<Dish.Type, Map<CaloricLevel, List<Dish>>> dishesByTypeCaloricLevel = menu.stream().collect(
                groupingBy(Dish::getType, groupingBy(Grouping::getCaloricLevel)));

        // multilevel grouping with any kind of collector, not just groupingBy()
        Map<Dish.Type, Long> typesCount = menu.stream().collect(
                groupingBy(Dish::getType, counting()));
        Map<Dish.Type, Integer> totalCaloriesByType = menu.stream().collect(
                groupingBy(Dish::getType, summingInt(Dish::getCalories)));

        // maxBy returns Optional...
        Map<Dish.Type, Optional<Dish>> mostCaloricByTypeOptional = menu.stream().collect(groupingBy(Dish::getType,
                maxBy(comparingInt(Dish::getCalories))));

        // ...which can be circumvented by adding collectingAndThen()
        Map<Dish.Type, Dish> mostCaloricByType = menu.stream().collect(groupingBy(Dish::getType,
                collectingAndThen(maxBy(Comparator.comparingInt(Dish::getCalories)), Optional::get)));

        Map<Dish.Type, Set<CaloricLevel>> caloricLevelsByType = menu.stream().collect(groupingBy(Dish::getType,
                mapping(Grouping::getCaloricLevel, toSet())));

        caloricLevelsByType = menu.stream().collect(groupingBy(Dish::getType,
                mapping(Grouping::getCaloricLevel, toCollection(HashSet::new))));
    }

    private static CaloricLevel getCaloricLevel(Dish dish) {
        if (dish.getCalories() <= 400) return CaloricLevel.DIET;
        else if (dish.getCalories() <= 700) return CaloricLevel.NORMAL;
        else return CaloricLevel.FAT;
    }
}
