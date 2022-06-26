package com.arash.tests.testtwo;

public class ArticlesDialogBox extends DialogBox {
    private Button button = new Button(this);
    private TextBox textBox = new TextBox(this);
    private ListBox listBox = new ListBox(this);
    public void change(UIControl control) {
        if(control == textBox) {
            // do this
        } else if(control == listBox) {
            // do this
        }
    }
}
