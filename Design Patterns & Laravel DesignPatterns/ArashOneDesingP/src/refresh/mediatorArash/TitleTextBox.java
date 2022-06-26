package refresh.mediatorArash;

public class TitleTextBox extends UIElement {
    private String title;

    public TitleTextBox(DialogBox dialogBox) {
        super(dialogBox);
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
        dialogBox.changed(this);
    }
}
