package com.arash.desingPatterns.command.undoCommand;

import java.util.ArrayDeque;
import java.util.Deque;

public class Histor {
    private Deque<UndoCommand> commands = new ArrayDeque<>();

    public void push(UndoCommand command) {
        commands.add(command);
    }
    public UndoCommand pop() {
        return commands.pop();
    }
    public int size() {
        return commands.size();
    }
}
