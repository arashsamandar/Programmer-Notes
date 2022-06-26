package com.arash.desingPatterns.command.undoCommand;

public interface UndoCommand extends Command {
    void unExecute();
}
