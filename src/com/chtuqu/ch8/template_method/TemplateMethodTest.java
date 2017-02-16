package com.chtuqu.ch8.template_method;

public class TemplateMethodTest {
    public static void main(String[] args) {
        new OnlineBanking2().processCustomer("123", c -> System.out.println(c.getName()));
    }
}
