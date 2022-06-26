package com.arash.tests.undocommand;

public class MakeBoldCommand implements UndoCommand {
    private Document document;
    private History history;
    private String prevContent;
    public MakeBoldCommand(Document document,History history) {
        this.document = document;
        this.history = history;
    }
    public void unExecute() {
        document.setContent(this.prevContent);
    }

    public void execute() {
        this.prevContent = document.getContent();
        document.makeContentBold();
        history.addCommand(this);
    }
}
