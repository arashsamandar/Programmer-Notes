package com.arash.tests.chainOfResponsibility;

public class HttpRequest { // It is the request that would be sent to our chain of responibility .
    private String username;
    private String password;

    public HttpRequest(String username,String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
