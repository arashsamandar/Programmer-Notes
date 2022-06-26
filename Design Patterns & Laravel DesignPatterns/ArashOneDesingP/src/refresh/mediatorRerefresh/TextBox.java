package refresh.mediatorRerefresh;

public class TextBox extends Element {
    private String title;

    public TextBox(Mediator mediator) {
        super(mediator);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
        mediator.changed(this);
    }
}
