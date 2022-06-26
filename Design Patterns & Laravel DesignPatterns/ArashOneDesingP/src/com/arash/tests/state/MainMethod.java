package com.arash.tests.state;

public class MainMethod {
    public static void main(String[] args) {
        var mainsheet = new MainSheet();
        mainsheet.setTool(new Brush());
        mainsheet.mouseDown();
        mainsheet.mouseUp();
    }
}
