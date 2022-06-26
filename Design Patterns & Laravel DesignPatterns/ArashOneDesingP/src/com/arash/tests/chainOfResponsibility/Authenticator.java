package com.arash.tests.chainOfResponsibility;

public class Authenticator extends Handler {
    public Authenticator(Handler next) {
        super(next);
    }

    @Override
    public boolean doHanle(HttpRequest request) {
        var isValid = (request.getUsername() == "Arash" && request.getPassword() == "samandar123");
        System.out.println("Authenticator Proccessed");
        return !isValid;
    }

}
