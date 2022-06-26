package com.arash.desingPatterns.strategy;

public class JpegCompressor implements Compressor {
    public void compress(String fileName) {
        System.out.println("Compressing Using Jpeg");
    }
}
