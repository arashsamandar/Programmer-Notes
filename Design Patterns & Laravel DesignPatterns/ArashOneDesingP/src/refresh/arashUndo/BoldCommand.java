package refresh.arashUndo;

public class BoldCommand implements UndoableCommand {
    private Document document;
    private History history;
    private String preContent;

    public BoldCommand(Document document, History history) {
        this.document = document;
        this.history = history;
    }

    public void execute() {
        preContent = document.getContent();
        document.makeBold();
        history.push(this);
    }

    public void unexecute() {
        document.setContent(preContent);
    }
}
