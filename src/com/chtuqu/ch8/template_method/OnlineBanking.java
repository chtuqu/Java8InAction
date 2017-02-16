package com.chtuqu.ch8.template_method;

public abstract class OnlineBanking {

    public void processCustomer(String id) {
        Customer c = null; // obtain customer from the DB
        makeCustomerHappy(c);
    }

    abstract void makeCustomerHappy(Customer c);
}
