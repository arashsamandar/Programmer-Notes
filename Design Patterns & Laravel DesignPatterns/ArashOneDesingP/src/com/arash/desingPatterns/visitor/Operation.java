package com.arash.desingPatterns.visitor;

public interface Operation {
    void apply(HeadingNode heading);
    void apply(AnchorNode anchorNode);
}
