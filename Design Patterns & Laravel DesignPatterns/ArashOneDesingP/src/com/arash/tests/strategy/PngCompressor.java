package com.arash.tests.strategy;

public class PngCompressor implements Compressor {
    @Override
    public void compress() {
        System.out.println("PNG Compressor Applied");
    }
}
