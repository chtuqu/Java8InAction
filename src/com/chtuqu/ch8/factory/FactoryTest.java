package com.chtuqu.ch8.factory;

import com.chtuqu.ch8.factory.dto.Product;

public class FactoryTest {
    public static void main(String[] args) {
        Product p1 = ClassicProductFactory.createProduct("loan");
        Product p2 = LambdaProductFactory.createProduct("stock");
    }
}
