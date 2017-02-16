package com.chtuqu.ch8.strategy;

public class StrategyTest {
    public static void main(String[] args) {
        boolean result;

        // try with implementing classes
        Validator numericValidator = new Validator(new IsNumeric());
        result = numericValidator.validate("aaaa"); // false
        Validator lowerCaseValidator = new Validator(new IsAllLowerCase());
        result = lowerCaseValidator.validate("bbbb"); // true

        // try with lambdas
        numericValidator = new Validator(s -> s.matches("\\d+"));
        result = numericValidator.validate("aaaa"); // false
        lowerCaseValidator = new Validator(s -> s.matches("[a-z]+"));
        result = lowerCaseValidator.validate("bbbb"); // true
    }
}
