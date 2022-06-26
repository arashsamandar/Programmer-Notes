package com.arash.tests.tteesst;

public class ListBox extends Observable {
    private String selection;

    public String getSelection() {
        return selection;
    }

    public void setSelection(String selection) {
        this.selection = selection;
        notifyObservers();
    }
}
