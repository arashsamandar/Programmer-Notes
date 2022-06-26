package refresh.commandUndo;

public interface UndoableCommand extends Command {
    void unexecute();
}
