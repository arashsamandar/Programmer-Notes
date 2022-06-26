package refresh.visitorRefresh;

public class MainMethod {
    public static void main(String[] args) {
        var document = new HTMLDocument();
        document.add(new AnchorNode());
        document.add(new HeadingNode());
        document.execute(new ConcereteOperation());
    }
}
