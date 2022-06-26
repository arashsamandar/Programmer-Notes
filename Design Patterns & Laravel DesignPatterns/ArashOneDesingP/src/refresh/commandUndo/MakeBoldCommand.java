package refresh.commandUndo;

public class MakeBoldCommand implements UndoableCommand {
    private Document document;
    private History history;
    private String prevContent;

    public MakeBoldCommand(Document document, History history) {
        this.document = document;
        this.history = history;
    }

    public void execute() {
        prevContent = document.getContent();
        document.makeBold();
        history.push(this);
    }

    public void unexecute() {
        document.setContent(prevContent);
    }
}
