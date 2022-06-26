package refresh.visitor;

public interface Operation {
    void apply(HTMLAnchor anchor);
    void apply(HTMLHeading heading);
}
