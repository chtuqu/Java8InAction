package com.chtuqu.ch8.factory;

import com.chtuqu.ch8.factory.dto.Product;
import com.chtuqu.ch8.factory.dto.impl.Bond;
import com.chtuqu.ch8.factory.dto.impl.Loan;
import com.chtuqu.ch8.factory.dto.impl.Stock;

public class ClassicProductFactory {
    public static Product createProduct(String type) {
        switch (type) {
            case "loan": return new Loan();
            case "stock": return new Stock();
            case "bond": return new Bond();
            default: throw new IllegalArgumentException("No such product " + type);
        }
    }
}
