package com.arash.desingPatterns.chainOfResponsibility;

public class Logger extends Handler {
    public Logger(Handler next) {
        super(next);
    }
    public boolean dohandle(HttpRequest request) {
        System.out.println("Loged");
        return false;
    }
}
