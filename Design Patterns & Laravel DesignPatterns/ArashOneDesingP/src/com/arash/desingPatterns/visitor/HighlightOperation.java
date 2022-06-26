package com.arash.desingPatterns.visitor;

public class HighlightOperation implements Operation{

    @Override
    public void apply(HeadingNode heading) {
        System.out.println("heading highlighted");
    }

    @Override
    public void apply(AnchorNode anchorNode) {
        System.out.println("anchor highlighted");
    }
}
