package refresh.mediatorArash;

public class ListBox extends UIElement {
    private String selection;

    public ListBox(DialogBox dialogBox) {
        super(dialogBox);
    }

    public String getSelection() {
        return selection;
    }
    public void setSelection(String selection) {
        this.selection = selection;
        dialogBox.changed(this);
    }
}
