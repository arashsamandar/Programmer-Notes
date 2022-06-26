package com.arash.desingPatterns.mediator;

public class ListBox extends UIControl {
    private String selection;

    public ListBox(DialogBox dialogBox) {
        super(dialogBox);
    }

    public String getSelection() {
        return selection;
    }

    public void setSelection(String selection) {
        this.selection = selection;
        owner.changed(this);
    }
}
