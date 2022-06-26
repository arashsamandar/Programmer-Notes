package com.arash.Lambdas;

public class MainMethod {
    public void myFunction() {
        var myObject = new ArashObject();
        myObject.getTools(() -> {
            // and here goes your code sir
            // or you can write it like bellow
        });
        myObject.getTools(new FunctionalInterface() {
            public void apply() {
                // and here goes your code .
            }
        });
    }
}
