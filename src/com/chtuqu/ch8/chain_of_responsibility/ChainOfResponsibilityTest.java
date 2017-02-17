package com.chtuqu.ch8.chain_of_responsibility;

import java.util.function.Function;
import java.util.function.UnaryOperator;

public class ChainOfResponsibilityTest {
    public static void main(String[] args) {
        System.out.println(testWithClasses());
        System.out.println(testWithLambdas());
    }

    private static String testWithClasses() {
        ProcessingObject<String> headerProcessing = new HeaderTextProcessing();
        ProcessingObject<String> spellCheckerProcessing = new SpellCheckerProcessing();

        headerProcessing.setSuccessor(spellCheckerProcessing);

        return headerProcessing.handle("labdas are sexy");
    }

    private static String testWithLambdas() {
        UnaryOperator<String> headerProcessing = input -> "From Raoul, Mario and Alan: " + input;
        UnaryOperator<String> spellCheckerProcessing = input -> input.replaceAll("labda", "lambda");

        Function<String, String> pipeline = headerProcessing.andThen(spellCheckerProcessing);

        return pipeline.apply("labdas are sexy");
    }
}
