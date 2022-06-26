package com.arash.Structural.decorator;

public class MainMethod {
    public static void main(String[] args) {
        storeCreditCard(new CompressedCloudStream(new EncryptedCloudStream(new CloudStream())));
    }
    public static void storeCreditCard(Stream stream) {
        stream.write("1234-2341-3466-5674");
    }
}
