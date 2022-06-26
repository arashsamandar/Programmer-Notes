package refresh.arashUndo;

public interface UndoableCommand extends Command {
    void unexecute();
}
