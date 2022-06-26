package com.arash.Structural.facade;

public class NotificationServer {
    // connect() -> Connection Object
    // authenticate(AppID,Key) -> Authentication Token Object
    // send(authToken,message,target)
    // connection.disconnect();
    public Connection connect(String ipAddress_of_NotificationServer) {
        return new Connection();
    }
    public AuthToken authenticate(String appId,String key) {
        return new AuthToken();
    }
    public void send(AuthToken authToken,Message message,String target) {
        System.out.println("Sending a Message");
    }
}
