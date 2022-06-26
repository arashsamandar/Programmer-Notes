package com.arash.desingPatterns.visitor;

public class AnchorNode implements HTMLNode {
    public void execute(Operation operation) {
        operation.apply(this);
    }
}
