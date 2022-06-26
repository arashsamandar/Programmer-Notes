package com.arash.Structural.composite;

public class Shape implements Component {
    @Override
    public void render() {
        System.out.println("Render The Shape");
    }

    @Override
    public void move() {
        System.out.println("Move Shape");
    }
}
