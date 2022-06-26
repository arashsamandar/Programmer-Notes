package com.arash.tests.command;

public class AddLabelCommand implements Command {
    private AddLabel addLabel;
    public AddLabelCommand(AddLabel addLabel) {
        this.addLabel = addLabel;
    }
    public void execute() {
        addLabel.addOneLabel();
    }
}
