package com.arash.tests.mediatortests;

public class Button extends UIControl {
    private boolean isActive;

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
        notifyHandlers();
    }
}
