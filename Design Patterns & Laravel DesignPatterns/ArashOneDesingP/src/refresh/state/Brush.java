package refresh.state;

public class Brush implements Tool {
    @Override
    public void select() {
        System.out.println("Brush Selected");
    }

    @Override
    public void draw() {
        System.out.println("Bursh Drawed");
    }
}
