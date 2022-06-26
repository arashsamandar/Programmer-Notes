package refresh.state;

public class canvas {
    private Tool myTool;
    public void mouseDown() {
        myTool.select();
    }
    public void mouseUp() {
        myTool.draw();
    }

    public Tool getMyTool() {
        return myTool;
    }

    public void setMyTool(Tool myTool) {
        this.myTool = myTool;
    }
}
