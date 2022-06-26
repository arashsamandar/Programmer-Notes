package com.arash.desingPatterns.chainOfResponsibility;

public class Authenticator extends Handler {
    public Authenticator(Handler next) {
        super(next);
    }
    public boolean dohandle(HttpRequest request) {
        var isValid = (request.getUserName() == "Arash"
                && request.getPassword() == "Samandar1234");

        System.out.println("Authentication");
        return !isValid;
    }
}
