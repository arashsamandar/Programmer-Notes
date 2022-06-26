package com.arash.desingPatterns.chainOfResponsibility;

public class MainMethod {
    public static void main(String[] args) {
        // authenticator -> logger -> compressor
        var compressor = new Compressor(null);
        var logger = new Logger(compressor);
        var authenticator = new Authenticator(logger);
        var server = new WebServer(authenticator);
        server.handle(new HttpRequest("Arash","Samandar1234"));

    }
}
