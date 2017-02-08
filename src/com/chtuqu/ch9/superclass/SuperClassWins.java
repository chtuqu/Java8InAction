package com.chtuqu.ch9.superclass;

interface A {
    default void hello() {
        System.out.println("Hello from A");
    }
}

class B {
    public void hello() {
        System.out.println("Hello from B");
    }
}

class C extends B implements A {
    public static void main(String[] args) {
        new C().hello();
    }
}