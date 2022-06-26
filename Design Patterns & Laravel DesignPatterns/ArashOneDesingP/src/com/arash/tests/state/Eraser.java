package com.arash.tests.state;

public class Eraser implements Tool {
    @Override
    public void mouseUp() {
        System.out.println("Eraser is mouseUp");
    }

    @Override
    public void mouseDown() {
        System.out.println("Eraser is MouseDown");
    }
}
