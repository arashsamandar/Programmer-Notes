package com.arash.tests.mediatorobserver;

public class Button extends UIControl {
    private boolean isEnabled;
    public void setEnabled(boolean enabled) {
        this.isEnabled = enabled;
        notifyObservers();
    }
    public boolean getEnabled() {
        return this.isEnabled;
    }
}
