package com.chtuqu.ch9.subinterface;

interface A {
    default void hello() {
        System.out.println("Hello from A");
    }
}

interface B extends A {
    default void hello() {
        System.out.println("Hello from B");
    }
}

class C implements A, B {
    public static void main(String[] args) {
        new C().hello();
    }
}