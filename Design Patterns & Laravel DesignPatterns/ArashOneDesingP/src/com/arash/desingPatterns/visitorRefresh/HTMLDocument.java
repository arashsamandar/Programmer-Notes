package com.arash.desingPatterns.visitorRefresh;

import java.util.ArrayList;
import java.util.List;

public class HTMLDocument {
    private List<DocumentNodes> nodes = new ArrayList<>();
    public void add(DocumentNodes node) {
        nodes.add(node);
    }
    public void execute(Operation operation) {
        for(var node : nodes) {
            node.execute(operation);
        }
    }
}
