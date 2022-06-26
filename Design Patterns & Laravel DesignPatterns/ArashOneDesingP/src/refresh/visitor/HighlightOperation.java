package refresh.visitor;

public class HighlightOperation implements Operation {
    @Override
    public void apply(HTMLAnchor anchor) {
        System.out.println("anchor highlited");
    }

    @Override
    public void apply(HTMLHeading heading) {
        System.out.println("heading highlighted");
    }
}
