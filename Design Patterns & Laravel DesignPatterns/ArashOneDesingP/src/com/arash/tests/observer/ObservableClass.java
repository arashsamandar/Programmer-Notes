package com.arash.tests.observer;

public class ObservableClass extends Observable {
    private int value;
    public int getValue() {
        return value;
    }
    public void setValue(int value) {
        this.value = value;
        notifyObservers();
    } // this is the Observer-Push Implementation . as here you need to :
    // first create a main class , and in there you create a
    // private ObservableClass obClass = new ObservableClass();
    // obclass.setValue(2); // which causes others to get the value and update themselfs .
}
