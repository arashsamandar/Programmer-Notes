package refresh.usingEventHandler;

public class TextBox extends UIElement {
    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
        notifyObservers();
    }
}
