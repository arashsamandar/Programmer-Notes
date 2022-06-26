package refresh.visitor;

public class HTMLAnchor implements HTMLNode {
    @Override
    public void execute(Operation operation) {
        operation.apply(this);
    }
}
