package com.arash.tests.mediator;

public class Button extends UIControl {
    private boolean isActive;
    public Button(DialogBox dialogBox) {
        super(dialogBox);
    }
    public void setActive(boolean isActive) {
        this.isActive = isActive;
        dialogBox.change(this);
    }
}
