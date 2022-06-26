package refresh.mediatorArash;

public class ArashDialogBox extends DialogBox {
    private Button button = new Button(this); // constructor has a super(owner)
    private ListBox listBox = new ListBox(this);
    private TitleTextBox titleTextBox = new TitleTextBox(this);
    public void changed(UIElement element) {
        if(element == listBox) {
            titleTextBox.setTitle(listBox.getSelection());
            button.setEnable(true);
        } else if(element == titleTextBox) {
            var content = titleTextBox.getTitle();
            var isEmpty = (content.isEmpty() || content == null);
            button.setEnable(!isEmpty);
        }
    }
    public void testTheApplication() {
        listBox.setSelection("Arash Samandar");
        System.out.println(titleTextBox.getTitle());
        System.out.println(button.isEnable());
    }
}
