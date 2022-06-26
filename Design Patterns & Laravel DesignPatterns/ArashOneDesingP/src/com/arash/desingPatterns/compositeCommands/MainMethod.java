package com.arash.desingPatterns.compositeCommands;

public class MainMethod {
    public static void main(String[] args) {
        var composite = new CompositeCommand();
        composite.add(new ResizeCommand());
        composite.add(new BlackAndWhiteCommand());
        composite.execute();
    }
}
