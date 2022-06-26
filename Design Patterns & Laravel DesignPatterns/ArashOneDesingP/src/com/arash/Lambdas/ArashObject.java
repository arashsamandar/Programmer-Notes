package com.arash.Lambdas;

public class ArashObject {
    public void setTools() {
        System.out.println("Settting the Toools");
    }
    public void getTools(FunctionalInterface functionalInterface) {
        System.out.println("Getting the Toools");
        functionalInterface.apply();
    }
}
