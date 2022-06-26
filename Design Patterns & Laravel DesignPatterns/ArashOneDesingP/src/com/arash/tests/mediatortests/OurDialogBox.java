package com.arash.tests.mediatortests;

public class OurDialogBox {
    private EditBox editBox = new EditBox();
    private TextBox textBox = new TextBox();
    private Button button = new Button();

    public OurDialogBox() {
        editBox.addEventHandler(this::editBoxChanged);
        textBox.addEventHandler(this::textBoxChanged);
    }

    public void Simulations() {
        editBox.setSelection("Arash Samandar Good");
        System.out.println("textbox : " + textBox.getContent());
        System.out.println("Button : " + button.isActive());
    }

    private void editBoxChanged() {
        textBox.setContent(editBox.getSelection());
        button.setActive(true);
    }
    private void textBoxChanged() {
        var content = textBox.getContent();
        var isEmpty = ((content == null) || content.isEmpty());
        button.setActive(!isEmpty);
    }
}
