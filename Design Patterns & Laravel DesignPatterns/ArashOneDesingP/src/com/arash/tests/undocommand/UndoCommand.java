package com.arash.tests.undocommand;

public interface UndoCommand extends Command {
    void unExecute();
}
