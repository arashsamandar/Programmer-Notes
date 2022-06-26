package com.arash.tests.chainOfResponsibility;

public class WebServer {
    private Handler handler;
    public WebServer(Handler handler) {
        this.handler = handler;
    }
    public void handle(HttpRequest request) {
        handler.handle(request); // sends and says to begin the handle process of the Classes that extends Handler
        // as you see it says handler.handle(request); which means-> gives the request to the first handler to begin .
    }
}
