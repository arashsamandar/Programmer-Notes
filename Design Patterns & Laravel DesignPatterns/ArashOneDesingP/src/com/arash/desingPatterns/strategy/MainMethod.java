package com.arash.desingPatterns.strategy;

import jdk.jfr.Name;

public class MainMethod {
    public static void main(String[] args) {
        var compressor = new PngCompressor();
        var filter = new BlackAndWhiteFilter();
        var imageStorage = new ImageStorage();
        imageStorage.store("samandar",compressor,filter);

        // TODO : or you can write it like this :

        new ImageStorage()
                .store("Arash",
                        new PngCompressor(),
                        new BlackAndWhiteFilter());

    }
}
