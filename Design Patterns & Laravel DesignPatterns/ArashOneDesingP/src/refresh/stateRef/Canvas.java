package refresh.stateRef;

public class Canvas {
    Tool tool;
    public void  mouseDown() {
        tool.mouseDown();
    }
    public void mouseUp() {
        tool.mouseUp();
    }
    public void setTool(Tool tool) {
        this.tool = tool;
    }
}