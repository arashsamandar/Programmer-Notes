package com.arash.tests.command;

public class Mainmethod {
    public static void main(String[] args) {
        var addlabel = new AddLabel();
        var addLabelCommand = new AddLabelCommand(addlabel);
        var btn = new Button(addLabelCommand);
        btn.click();
    }
}
