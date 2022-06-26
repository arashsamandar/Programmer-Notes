package com.arash.Structural.Adapter.arashFilters;

import com.arash.Structural.Adapter.Image;

public class Caramel {
    public void init() {
        System.out.println("Caramel Initiated");
    }
    public void render(Image image) {
        System.out.println("Applying Caramel filter to image");
    }
}
