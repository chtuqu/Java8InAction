package com.chtuqu.ch3.lambda_constructor_map.dto;

public class Orange extends Fruit {

    private float someRate;

    public Orange() {}

    public Orange(int weight) {
        this.weight = weight;
    }

    public Orange(int weight, String color) {
        this(weight);
        this.color = color;
    }

    public Orange(int weight, String color, float someRate) {
        this(weight, color);
        this.someRate = someRate;
    }
}
