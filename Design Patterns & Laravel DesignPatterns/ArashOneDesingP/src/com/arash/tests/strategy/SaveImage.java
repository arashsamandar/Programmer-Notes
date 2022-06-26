package com.arash.tests.strategy;

public class SaveImage {
    private Filter filter;
    private Compressor compressType;
    public SaveImage(Compressor compressor,Filter filter) {
        this.compressType = compressor;
        this.filter = filter;
    }
    public void saveImage() {
        filter.apply();
        compressType.compress();
    }
}
