package com.chtuqu.ch3.functional_interfaces;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class FunctionTest {
    public static void main(String[] args) {
        List<Integer> res = map(Arrays.asList("lambdas", "in", "action"), String::length);
        System.out.println(res);
    }

    private static <T, R> List<R> map(List<T> list, Function<T, R> func) {
        List<R> resultList = new ArrayList<>();
        for (T s : list) {
            resultList.add(func.apply(s));
        }
        return resultList;
    }
}
