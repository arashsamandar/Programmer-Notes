package com.arash.tests.undocommand;

public class MainMethod {
    public static void main(String[] args) {
        var document = new Document();
        var history = new History();
        document.setContent("Arash samandar");
        var boldCommand = new MakeBoldCommand(document,history);
        boldCommand.execute(); // makes the content bold
        System.out.println(document.getContent());

        
    }
}
