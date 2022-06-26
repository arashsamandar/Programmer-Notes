package com.arash.tests.chainOfResponsibility;

public abstract class Handler {
    private Handler next;
    public Handler(Handler next) {
        this.next = next;
    }
    public void handle(HttpRequest request) {
        if(doHanle(request)) {
            return;
        }
        if(next != null) {
            next.handle(request);
        }
    }
    public abstract boolean doHanle(HttpRequest request);
}
/*
well this is how it works sir . this is the logic i can say for the while of this chain of responsibility that sits the Handler
abstract method .
 */
