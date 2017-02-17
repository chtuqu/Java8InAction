package com.chtuqu.ch8.factory;

import com.chtuqu.ch8.factory.dto.Product;
import com.chtuqu.ch8.factory.dto.impl.Bond;
import com.chtuqu.ch8.factory.dto.impl.Loan;
import com.chtuqu.ch8.factory.dto.impl.Stock;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class LambdaProductFactory {

    private final static Map<String, Supplier<Product>> map = new HashMap<>();

    static {
        map.put("loan", Loan::new);
        map.put("stock", Stock::new);
        map.put("bond", Bond::new);
    }

    public static Product createProduct(String type) {
        Supplier<Product> supplier = map.get(type);
        if (supplier != null) {
            return supplier.get();
        }
        throw new IllegalArgumentException("No such product " + type);
    }
}
