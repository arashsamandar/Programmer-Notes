package com.arash.desingPatterns.observer;

public class SpreadSheet implements Observer {
    @Override
    public void update(int value) {
        System.out.println("SpreadSheet Got Notified With : " + value);
    }
}
