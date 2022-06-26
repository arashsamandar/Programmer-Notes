package com.arash.desingPatterns.strategy;

public class BlackAndWhiteFilter implements Filter {
    public void apply(String fileName) {
        System.out.println("Applyting Black & White Filter");
    }
}
