package com.chtuqu.ch10.optional_example.dto;

import java.util.Optional;

public class Car {
    private Optional<Insurance> insurance;

    public Optional<Insurance> getInsurance() {
        return insurance;
    }
}
