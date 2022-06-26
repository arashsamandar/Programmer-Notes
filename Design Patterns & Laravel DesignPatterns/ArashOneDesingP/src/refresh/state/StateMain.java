package refresh.state;

import com.arash.desingPatterns.state.Brush;
import com.arash.desingPatterns.state.Canvas;

public class StateMain {
    public static void main(String[] args) {
        var canvas = new Canvas();
        canvas.setCurrentTool(new Brush());
        canvas.mouseUp();
        canvas.mouseDown();
    }
}
