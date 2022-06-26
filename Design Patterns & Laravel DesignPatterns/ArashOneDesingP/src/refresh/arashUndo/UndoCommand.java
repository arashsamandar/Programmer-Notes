package refresh.arashUndo;

public class UndoCommand implements Command {
    private History history;

    public UndoCommand(History history) {
        this.history = history;
    }

    public void execute() {
        history.pop().unexecute();
    }
}
