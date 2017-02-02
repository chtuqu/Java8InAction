package com.chtuqu.ch3.lambda_constructor_map;

import com.chtuqu.ch3.lambda_constructor_map.dto.Fruit;
import com.chtuqu.ch3.lambda_constructor_map.dto.Kiwi;
import com.chtuqu.ch3.lambda_constructor_map.dto.Orange;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class ConstructorMapTest {
    private static Map<String, Function<Integer, Fruit>> map = new HashMap<>();

    static {
        map.put("kiwi", Kiwi::new);
        map.put("orange", Orange::new);
    }

    public static void main(String[] args) {
        System.out.println(createFruit("kiwi", 7));
        System.out.println(createFruit("orange", 11));
    }

    private static Fruit createFruit(String fruitName, int i) {
        return map.get(fruitName.toLowerCase()).apply(i);
    }
}
