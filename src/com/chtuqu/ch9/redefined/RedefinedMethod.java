package com.chtuqu.ch9.redefined;

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

abstract class C implements A {
    // once it's redefined here, ...
    @Override
    abstract public void hello();
}

class D extends C implements B {
    public static void main(String[] args) {
        new D().hello();
    }

    // ...you're forced to override it here, even though default implementations exist
    @Override
    public void hello() {
        System.out.println("Hello from D");
    }
}
