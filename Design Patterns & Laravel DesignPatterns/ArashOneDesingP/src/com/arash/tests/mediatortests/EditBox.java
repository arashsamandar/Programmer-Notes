package com.arash.tests.mediatortests;

public class EditBox extends UIControl {
    private String selection;

    public String getSelection() {
        return selection;
    }

    public void setSelection(String selection) {
        this.selection = selection;
        notifyHandlers();
    }
}
