package com.arash.desingPatterns.state;

public class Eraser implements Tool {
    @Override
    public void mouseDown() {
        System.out.println("Eraser Icon");
    }

    @Override
    public void mouseUp() {
        System.out.println("Draw a Eraser");
    }
}
