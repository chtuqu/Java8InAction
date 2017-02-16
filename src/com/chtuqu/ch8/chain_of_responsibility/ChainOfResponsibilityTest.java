package com.chtuqu.ch8.chain_of_responsibility;

public class ChainOfResponsibilityTest {
    public static void main(String[] args) {
        ProcessingObject<String> headerProcessing = new HeaderTextProcessing();
        ProcessingObject<String> spellCheckerProcessing = new SpellCheckerProcessing();

        headerProcessing.setSuccessor(spellCheckerProcessing);

        String result = headerProcessing.handle("labdas are sexy");
        System.out.println(result);
    }
}
