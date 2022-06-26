package com.arash.tests.obserevrte;

import java.util.ArrayList;
import java.util.List;

public class Subject {
    private List<Observer> observers = new ArrayList<>();
    public void addObserver(Observer observer) {
        observers.add(observer);
    }
    public void notthem() {
        for(var ob : observers) {
            ob.update();
        }
    }
}
