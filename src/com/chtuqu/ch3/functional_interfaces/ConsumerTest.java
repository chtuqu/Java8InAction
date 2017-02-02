package com.chtuqu.ch3.functional_interfaces;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerTest {
    public static void main(String[] args) {
        forEach(Arrays.asList(1,2,3,4,5), System.out::println);
    }

    private static <T> void forEach(List<T> list, Consumer<T> c) {
        for (T e : list) {
            c.accept(e);
        }
    }
}
