package com.arash.tests.testtwo;

public class Button extends UIControl {
    private boolean isActive;
    public Button(DialogBox dialogBox) {
        super(dialogBox);
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
        dialogBox.change(this);
    }
}
