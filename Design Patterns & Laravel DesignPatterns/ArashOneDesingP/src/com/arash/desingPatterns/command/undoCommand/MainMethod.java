package com.arash.desingPatterns.command.undoCommand;

public class MainMethod {
    public static void main(String[] args) {
        var history = new Histor();
        var document = new Document();
        document.setContent("Arash Samandar");

        var boldCommand = new MakeBoldCommand(document,history);
        boldCommand.execute();
        System.out.println(document.getContent());

        var undoCommand = new Undo(history);
        undoCommand.execute();
        System.out.println(document.getContent());

    }
}
