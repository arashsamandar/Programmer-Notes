package com.arash.desingPatterns.mediator;

public class ArticlesDialogBox extends DialogBox {
    private ListBox articlesListBox = new ListBox(this);
    private TextBox titleTextBox = new TextBox(this);
    private Button saveButton = new Button(this);
    public void simulateUserInteraction() {
        articlesListBox.setSelection("Arash samandar");
        System.out.println("TextBox : " + titleTextBox.getContent());
        System.out.println("Button is : " + saveButton.isEnabled());
    }
    public void changed(UIControl control) {
        if(control == articlesListBox) {
            articleSelected();
        } else if(control == titleTextBox) {
            titleChanged();
        }
    }
    private void articleSelected() {
        titleTextBox.setContent(articlesListBox.getSelection());
        saveButton.setEnabled(true);
    }
    private void titleChanged() {
        var content = titleTextBox.getContent();
        var isEmpty = ((content == null) || content.isEmpty());
        saveButton.setEnabled(!isEmpty);
    }
}
