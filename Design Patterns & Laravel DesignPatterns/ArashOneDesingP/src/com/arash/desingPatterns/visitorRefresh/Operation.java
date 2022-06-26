package com.arash.desingPatterns.visitorRefresh;

public interface Operation {
    void apply(AnchorNode node);
    void apply(HeadingNode node);
}
