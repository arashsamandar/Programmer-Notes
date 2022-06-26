package refresh.unCommand;

public class BoldCommand implements UndoableCommand {
    private String prevContent;
    private History history;
    private Document document;

    public BoldCommand(History history, Document document) {
        this.history = history;
        this.document = document;
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
