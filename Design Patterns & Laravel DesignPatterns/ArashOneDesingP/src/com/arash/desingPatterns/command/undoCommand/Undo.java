package com.arash.desingPatterns.command.undoCommand;

public class Undo implements Command {
    private Histor history;

    public Undo(Histor history) {
        this.history = history;
    }

    @Override
    public void execute() {
        if(history.size() > 0) {
            history.pop().unExecute();
        }
    }
}
