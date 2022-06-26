package com.arash.tests.undocommand;

public class Document {
    private String content;

    public void makeContentBold() {
        content =  "<b>" + content + "</b>";
    }

    public void setContent(String content) {
        this.content = content;
    }
    public String getContent() {
        return this.content;
    }
}
