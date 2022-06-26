package com.arash.tests.testtwo;

public class TextBox extends UIControl {
    private String content;
    public TextBox(DialogBox dialogBox) {
        super(dialogBox);
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
        dialogBox.change(this);
    }
}
