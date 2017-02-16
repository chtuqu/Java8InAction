package com.chtuqu.ch8.template_method;

import java.util.function.Consumer;

public class OnlineBanking2 {

    public void processCustomer(String id, Consumer<Customer> makeCustomerHappy) {
        Customer c = null; // obtain customer from the DB
        makeCustomerHappy.accept(c);
    }

}
