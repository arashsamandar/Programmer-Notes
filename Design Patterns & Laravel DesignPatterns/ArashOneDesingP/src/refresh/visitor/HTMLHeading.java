package refresh.visitor;

public class HTMLHeading implements HTMLNode {
    @Override
    public void execute(Operation operation) {
        operation.apply(this);
    }
}
