package com.chtuqu.ch8.observer;

public class ObserverTest {
    public static void main(String[] args) {
        Subject subject = new Feed();

//        registerWithClasses(subject);
//        registerWithLambdas(subject);

        subject.notifyObservers("money-queen-wine");
    }

    private static void registerWithClasses(Subject subject) {
        subject.registerObserver(new NYTimes());
        subject.registerObserver(new Guardian());
        subject.registerObserver(new LeMonde());
    }

    private static void registerWithLambdas(Subject subject) {
        subject.registerObserver(tweet -> System.out.println("Breaking news in NY! " + tweet));
        subject.registerObserver(tweet -> System.out.println("Yet another news in London... " + tweet));
        subject.registerObserver(tweet -> System.out.println("Today cheese, wine and news! " + tweet));
    }
}
