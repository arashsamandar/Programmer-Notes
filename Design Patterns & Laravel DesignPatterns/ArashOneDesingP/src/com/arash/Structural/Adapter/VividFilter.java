package com.arash.Structural.Adapter;

public class VividFilter implements Filter {
    public void apply(Image image) {
        System.out.println("Applying Vivid Filter To Image");
    }
}
