package com.chtuqu.ch6;

import com.chtuqu.ch4.DishMenu;
import com.chtuqu.ch4.dto.Dish;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.*;

public class Partitioning {
    public static void main(String[] args) {
        List<Dish> menu = DishMenu.menu;

        // simple partitioning
        Map<Boolean, List<Dish>> partitionedMenu = menu.stream().collect(partitioningBy(Dish::isVegetarian));

        // partitioning with downstream collector
        Map<Boolean, Map<Dish.Type, List<Dish>>> vegetarianDishesByType =
                menu.stream().collect(partitioningBy(Dish::isVegetarian, groupingBy(Dish::getType)));

        // more examples
        Map<Boolean, Dish> mostCaloricPartitionedByVegetarian =
                menu.stream().collect(
                        partitioningBy(Dish::isVegetarian,
                                collectingAndThen(maxBy(comparingInt(Dish::getCalories)), Optional::get)));

        Map<Boolean, Map<Boolean, List<Dish>>> vegetarianDishesByHeavyCal =
                menu.stream().collect(partitioningBy(Dish::isVegetarian, partitioningBy(d -> d.getCalories() > 500)));

        Map<Boolean, Long> vegetarianDishesByCount = menu.stream().collect(partitioningBy(Dish::isVegetarian, counting()));
    }
}
