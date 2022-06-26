package com.arash.tests.undocommand;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class History {
    private Deque<UndoCommand> commands = new ArrayDeque<>();
    public void addCommand(UndoCommand command) {
        commands.add(command);
    }
    public UndoCommand pop() {
        return commands.pop();
    }

    public int size() {
        return commands.size();
    }
}
