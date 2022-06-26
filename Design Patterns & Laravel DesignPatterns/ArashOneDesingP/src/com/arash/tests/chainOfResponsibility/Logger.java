package com.arash.tests.chainOfResponsibility;

public class Logger extends Handler {
    public Logger(Handler next) {
        super(next);
    }

    @Override
    public boolean doHanle(HttpRequest request) {
        System.out.println("Logger Initiated");
        return false;
    }

}
