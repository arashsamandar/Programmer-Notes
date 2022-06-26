package com.arash.desingPatterns.visitorRefresh;

public class AnchorNode implements DocumentNodes {
    @Override
    public void execute(Operation operation) {
        operation.apply(this);
    }
}
