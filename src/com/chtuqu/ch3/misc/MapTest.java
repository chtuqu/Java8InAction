package com.chtuqu.ch3.misc;

import com.chtuqu.ch3.lambda_constructor_map.dto.Orange;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class MapTest {
    public static void main(String[] args) {
        List<Integer> weights = Arrays.asList(7, 3, 4, 10);
        List<Orange> oranges = map(weights, Orange::new);
        System.out.println(oranges);
    }

    private static List<Orange> map(List<Integer> weights, Function<Integer, Orange> func) {
        List<Orange> resultList = new ArrayList<>();
        for (int i : weights) {
            resultList.add(func.apply(i));
        }
        return resultList;
    }
}
