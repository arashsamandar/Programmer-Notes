package refresh.unCommand;

public interface UndoableCommand extends Command {
    void unexecute();
}
