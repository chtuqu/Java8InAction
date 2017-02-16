package com.chtuqu.ch8.strategy;

@FunctionalInterface
public interface ValidationStrategy {
    boolean execute(String s);
}
