package com.arash.desingPatterns.command.undoCommand;

public class MakeBoldCommand implements UndoCommand {
    private String prevContent;
    private Document document;
    private Histor history;

    public MakeBoldCommand(Document document,Histor history) {
        this.history = history;
        this.document = document;
    }

    @Override
    public void unExecute() {
        document.setContent(prevContent);
    }

    @Override
    public void execute() {
        prevContent = document.getContent();
        document.makeBold();
        history.push(this);
    }
}
