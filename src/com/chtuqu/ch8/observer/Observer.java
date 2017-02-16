package com.chtuqu.ch8.observer;

@FunctionalInterface
public interface Observer {
    void notify(String tweet);
}
