package com.arash.desingPatterns.state;

import refresh.state.Tools;

public class CanvasTest {
    Tool tool;
    public CanvasTest(Tool tool) {

    }
    public void mouseDown() {
       tool.mouseDown();
    }
    public void mouseUp() {
        tool.mouseUp();
    }
}
