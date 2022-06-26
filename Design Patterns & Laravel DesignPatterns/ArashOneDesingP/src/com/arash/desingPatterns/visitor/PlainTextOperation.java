package com.arash.desingPatterns.visitor;

public class PlainTextOperation implements Operation {
    @Override
    public void apply(HeadingNode heading) {
        System.out.println("text-heading");
    }

    @Override
    public void apply(AnchorNode anchorNode) {
        System.out.println("text-anchor");
    }
}
