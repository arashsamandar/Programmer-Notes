package refresh.visitorRefresh;

public class ConcereteOperation implements Operation {
    @Override
    public void apply(HeadingNode headingNode) {
        System.out.println("heading operation done");
    }

    @Override
    public void apply(AnchorNode anchorNode) {
        System.out.println("anchor operation done");
    }
}
