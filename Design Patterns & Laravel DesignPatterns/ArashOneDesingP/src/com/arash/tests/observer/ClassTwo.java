package com.arash.tests.observer;

public class ClassTwo implements Observer {
    private ObservableClass obclass;
    public ClassTwo(ObservableClass obclass) {
        this.obclass = obclass;
    }
    public void update() {
        System.out.println("This is the Pull method : " + obclass.getValue());
    }
}
