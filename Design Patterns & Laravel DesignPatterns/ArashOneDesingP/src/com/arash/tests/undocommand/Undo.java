package com.arash.tests.undocommand;

public class Undo implements Command {
    private History history;
    public Undo(History history) {
        this.history = history;
    }
    public void execute() {
        if(history.size() > 0){
            history.pop().unExecute();
        }
    }
}
