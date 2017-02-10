package com.chtuqu.ch10.null_example;

import com.chtuqu.ch10.null_example.dto.Car;
import com.chtuqu.ch10.null_example.dto.Insurance;
import com.chtuqu.ch10.null_example.dto.Person;

public class DefensiveChecking {

    // prone to NPE!
    public String getCarInsuranceName(Person person) {
        return person.getCar().getInsurance().getName();
    }

    // bloats the code with deeply nested if blocks
    public String getCarInsuranceName2(Person person) {
        if (person != null) {
            Car car = person.getCar();
            if (car != null) {
                Insurance insurance = car.getInsurance();
                if (insurance != null) {
                    return insurance.getName();
                }
            }
        }
        return "Unknown";
    }

    // bloats the code with multiple exit points
    public String getCarInsuranceName3(Person person) {
        String unknown = "Unknown";
        if (person == null) {
            return unknown;
        }

        Car car = person.getCar();
        if (car == null) {
            return unknown;
        }

        Insurance insurance = car.getInsurance();
        if (insurance == null) {
            return unknown;
        }

        return insurance.getName();
    }
}
