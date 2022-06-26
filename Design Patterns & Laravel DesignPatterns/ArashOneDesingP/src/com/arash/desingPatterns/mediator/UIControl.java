package com.arash.desingPatterns.mediator;

public class UIControl {
    protected DialogBox owner;
    public UIControl(DialogBox owner) {
        this.owner = owner;
    }
}
