package com.arash.Structural.facade;

public class Mainmethod {
    public static void main(String[] args) {
//        var server = new NotificationServer();
//        var connection = server.connect("ip");
//        var authToken = server.authenticate("appId","key");
//        var message = new Message("hello world");
//        server.send(authToken,message,"targetDevice");
//        connection.disconnect();
        var service = new NotificationService();
        service.send("Hello World","TargetDevice");
    }
}
