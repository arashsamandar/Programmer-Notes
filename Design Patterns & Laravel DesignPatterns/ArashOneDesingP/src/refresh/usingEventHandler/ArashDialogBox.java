package refresh.usingEventHandler;

public class ArashDialogBox { // there is no dialogBox abstract class that it extends form anymore
    private Button button = new Button();
    private ListBox listBox = new ListBox();
    private TextBox textBox = new TextBox();

    public ArashDialogBox() {
        listBox.attach(this::caseListBoxChanged);
        textBox.attach(this::caseTextBoxChanged);
    }
    private void caseListBoxChanged() {
        var content = listBox.getListboxTitle();
        textBox.setTitle(content);
        button.setEnabled(true);
    }
    private void caseTextBoxChanged() {
        var content = textBox.getTitle();
        var flag = !content.isEmpty();
        button.setEnabled(flag);
    }
    public void simulateListBoxChange() {
        listBox.setListboxTitle("Arash Samandar");
        System.out.println(textBox.getTitle());
        System.out.println(button.isEnabled());
    }
}
