package com.arash.tests.mediatorobserver;


public class ArticlesDialogBox {
    private ListBox articlesListBox = new ListBox();
    private TextBox  titleTextBox = new TextBox();
    private  Button saveButton = new Button();

    public ArticlesDialogBox() {
        articlesListBox.addEventHandler(this::articleSelected); // means : add me to the observers list or List<eventHandlers> , and then my handle method is articleSelected
        /**
         * public ArticlesDialogBox() {
         *         articlesListBox.addEventHandler(new EventHandler() {
         *             @Override
         *             public void handle() {
         *                  this::articleSelected();
         *             }
         *         });
         *     }
         * is like putting the whole articleSelected , in the handle method of
         * ListBox , which extends the EventHandler .
         */
        titleTextBox.addEventHandler(this::titleChanged);
    }

    public void simulateUserInteraction() {
        articlesListBox.setSelection("Arash samandar"); // cause notify is in
        // set selection and would be activated by it .
        System.out.println("TextBox : " + titleTextBox.getContent());
        System.out.println("Button is : " + saveButton.getEnabled());
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
