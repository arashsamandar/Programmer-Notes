package refresh.visitorRefresh;

import java.util.ArrayList;
import java.util.List;

public class HTMLDocument {
    private List<HTMLNode> nodes = new ArrayList<>();
    public void add(HTMLNode htmlNode) {
        nodes.add(htmlNode);
    }
    public void execute(Operation operation) {
        for(var node : nodes) {
            node.execute(operation);
        }
    }
}
