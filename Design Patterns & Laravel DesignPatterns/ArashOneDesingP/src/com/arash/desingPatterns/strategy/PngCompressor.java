package com.arash.desingPatterns.strategy;

public class PngCompressor implements Compressor {
    public void compress(String fileName) {
        System.out.println("compressing using Png");
    }
}
