package com.arash.desingPatterns.visitor;

public class MainMethod {
    public static void main(String[] args) {
        var document = new HTMLDocument();
        document.add(new HeadingNode());
        document.add(new AnchorNode());
        document.execute(new PlainTextOperation());
    }
}
