package com.arash.desingPatterns.mediator;

public class Button extends UIControl {
    private boolean isEnabled;

    public Button(DialogBox dialogBox) {
        super(dialogBox);
    }

    public boolean isEnabled() {
        return isEnabled;
    }

    public void setEnabled(boolean enabled) {
        isEnabled = enabled;
        owner.changed(this);
    }
}
