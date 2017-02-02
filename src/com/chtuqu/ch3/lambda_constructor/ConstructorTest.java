package com.chtuqu.ch3.lambda_constructor;

import com.chtuqu.ch3.lambda_constructor_map.dto.Orange;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class ConstructorTest {
    public static void main(String[] args) {
        Supplier<Orange> c1 = Orange::new;
        Orange a1 = c1.get();

        Function<Integer, Orange> c2 = Orange::new;
        Orange a2 = c2.apply(5);

        BiFunction<Integer, String, Orange> c3 = Orange::new;
        Orange a3 = c3.apply(7, "green");

        TriFunction<Integer, String, Float, Orange> c4 = Orange::new;
        Orange a4 = c4.apply(12, "yellow", 0.65f);
    }
}
