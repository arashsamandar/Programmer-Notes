package com.arash.Structural.decorator;

public class EncryptedCloudStream implements Stream {
    private Stream stream;
    public EncryptedCloudStream(Stream stream) {
        this.stream = stream;
    }
    public void write(String data) {
        var encrypted = encrypting(data);
        stream.write(encrypted);
    }
    private String encrypting(String data) {
        return "&^*%&*%^%*&^%@#!";
    }
}
