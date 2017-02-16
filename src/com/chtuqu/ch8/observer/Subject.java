package com.chtuqu.ch8.observer;

public interface Subject {
    void notifyObservers(String tweet);
    void registerObserver(Observer o);
}
