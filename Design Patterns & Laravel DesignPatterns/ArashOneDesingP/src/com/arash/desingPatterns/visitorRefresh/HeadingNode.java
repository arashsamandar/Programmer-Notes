package com.arash.desingPatterns.visitorRefresh;

public class HeadingNode implements DocumentNodes {
    @Override
    public void execute(Operation operation) {
        operation.apply(this);
    }
}
