package com.chtuqu.ch10.optional_example.dto;

import java.util.Optional;

public class Person {
    private Optional<Car> car;

    public Optional<Car> getCar() {
        return car;
    }
}
