package refresh.commandUndo;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class History {
    private Deque<UndoableCommand> undoableCommands = new ArrayDeque<>();
    public void push(UndoableCommand undoableCommand) {
        undoableCommands.add(undoableCommand);
    }
    public UndoableCommand pop() {
        return undoableCommands.pop();
    }
}
