package com.arash.desingPatterns.visitorRefresh;

public class HighLightOperation implements Operation {
    @Override
    public void apply(AnchorNode node) {
        System.out.println("HighLight Operation Done on the AnchorNode");
    }

    @Override
    public void apply(HeadingNode node) {
        System.out.println("HighLight Operation Done on the Heading Node");
    }
}
