package refresh.mediatorArash;

public class Button extends UIElement {
    private boolean isEnable;

    public Button(DialogBox dialogBox) {
        super(dialogBox);
    }

    public boolean isEnable() {
        return isEnable;
    }
    public void setEnable(boolean isEnabled) {
        this.isEnable = isEnabled;
        dialogBox.changed(this);
        // Says : DialogBox , I have changed
    }
}
