package com.arash.tests.state;

public class Brush implements Tool {
    @Override
    public void mouseUp() {
        System.out.println("Brush is mouseUp");
    }

    @Override
    public void mouseDown() {
        System.out.println("Brush is mouseDown");
    }
}
