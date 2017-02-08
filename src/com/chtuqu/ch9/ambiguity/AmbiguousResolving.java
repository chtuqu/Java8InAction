package com.chtuqu.ch9.ambiguity;

interface A {
    default void hello() {
        System.out.println("Hello from A");
    }
}

interface B {
    default void hello() {
        System.out.println("Hello from B");
    }
}

class C implements A, B {
    // you have to override, otherwise it's an ambiguous reference
    @Override
    public void hello() {
        B.super.hello(); // note the X.super syntax, new for Java 8
    }
}