package com.arash.desingPatterns.memento;


public class MainMethod {
    public static void main(String[] args) {
        var editor = new Editor();
        var history = new History();
        editor.setContent("arash");
        history.push(editor.createState());
        editor.setContent("samandar");
        history.push(editor.createState());
        System.out.println(editor.getContent());
        editor.restoreState(history.pop());
        editor.restoreState(history.pop());
        System.out.println(editor.getContent());
    }
}
