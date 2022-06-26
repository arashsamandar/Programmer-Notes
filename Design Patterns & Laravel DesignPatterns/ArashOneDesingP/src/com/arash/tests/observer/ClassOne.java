package com.arash.tests.observer;

public class ClassOne implements Observer {
    private ObservableClass obclass;
    public ClassOne(ObservableClass obclass) {
        this.obclass = obclass;
    }
    public void update() {
        System.out.println("This is The Pull method With : " + obclass.getValue());
    }
}
