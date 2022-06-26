package refresh.mediatorRerefresh;

public class MyMediator extends Mediator {
    private TextBox textBox = new TextBox(this);
    private ListBox listBox = new ListBox(this);
    public void changed(Element element) {
        if(element == textBox) {
            listBox.setListBoxTitle(textBox.getTitle());
        }
        else if(element == listBox) {
            textBox.setTitle(listBox.getListBoxTitle());
        }
    }
    public void simulateTextBoxChange() {
        textBox.setTitle("Arash Samandar");
        System.out.println(listBox.getListBoxTitle());
    }
}
