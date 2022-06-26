package com.arash.Structural.composite;

public class MainMethod {
    public static void main(String[] args) {
        var group1 = new Group();
        group1.add(new Shape());
        group1.add(new Shape());

        var group2 = new Group();
        group2.add(new Group());
        group2.add(group1);
        group2.render();
    }
}
