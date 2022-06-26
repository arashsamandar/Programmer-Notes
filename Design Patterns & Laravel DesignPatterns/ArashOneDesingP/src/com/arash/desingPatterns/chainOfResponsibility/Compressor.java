package com.arash.desingPatterns.chainOfResponsibility;

public class Compressor extends Handler {
    public Compressor(Handler next) {
        super(next);
    }

    @Override
    public boolean dohandle(HttpRequest request) {
        System.out.println("Compress");
        return false;
    }
}
