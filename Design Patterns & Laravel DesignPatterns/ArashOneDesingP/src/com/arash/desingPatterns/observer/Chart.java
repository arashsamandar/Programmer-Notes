package com.arash.desingPatterns.observer;

public class Chart implements Observer {
    @Override
    public void update(int value) {
        System.out.println("Chart Got Notified " + "With : " + value);
    }
}
