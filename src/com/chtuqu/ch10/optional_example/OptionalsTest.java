package com.chtuqu.ch10.optional_example;

import com.chtuqu.ch10.optional_example.dto.Car;
import com.chtuqu.ch10.optional_example.dto.Insurance;
import com.chtuqu.ch10.optional_example.dto.Person;

import java.util.Optional;

public class OptionalsTest {
    public String getInsuranceName(Optional<Person> person) {
        return person
                .flatMap(Person::getCar)
                .flatMap(Car::getInsurance)
                .map(Insurance::getName)
                .orElse("unknown");
    }
}
