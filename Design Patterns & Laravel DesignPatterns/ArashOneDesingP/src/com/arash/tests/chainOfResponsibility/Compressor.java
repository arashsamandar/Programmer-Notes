package com.arash.tests.chainOfResponsibility;

public class Compressor extends Handler {
    public Compressor(Handler next) {
        super(next);
    }

    @Override
    public boolean doHanle(HttpRequest request) {
        System.out.println("Compressor Engaged");
        return false;
    }
}
