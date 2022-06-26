package com.arash.tests.state;

public class MainSheet {
    private Tool tool;
    public void mouseUp() {
        tool.mouseUp();
    }
    public void mouseDown() {
        tool.mouseDown();
    }
    public Tool getTool() {
        return tool;
    }
    public void setTool(Tool tool) {
        this.tool = tool;
    }
}
