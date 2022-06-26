package refresh.mediatorObserver;

public class ElementOne extends UIElementObservable {
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
        notifyEventHandlers();
    }
}
