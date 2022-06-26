package refresh.visitor;

import com.arash.desingPatterns.visitor.HeadingNode;

public class MainMethod {
    public static void main(String[] args) {
        var document = new HTMLDocument();
        document.add(new HTMLHeading());
        document.add(new HTMLAnchor());
        document.execute(new HighlightOperation());
    }
}
