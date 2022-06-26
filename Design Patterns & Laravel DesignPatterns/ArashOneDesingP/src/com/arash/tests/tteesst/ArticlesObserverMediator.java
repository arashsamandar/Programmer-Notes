package com.arash.tests.tteesst;

public class ArticlesObserverMediator {
    private TextBox textBox = new TextBox();
    private ListBox listBox = new ListBox();
    public ArticlesObserverMediator() {
        // this creates an EventHandler of Type TextBox
        // and then implements it's hanle() method to { this::textBoxSelected }
        // and adds it to the eventHandlers.add(
        textBox.addEventHandler(this::textBoxSelected);
        // and the above description of chain of commands would also add ListBox
        // to the eventHandler.add(
        listBox.addEventHandler(this::listBoxSelected);
    }

    public void textBoxSelected(){
        // do whatever when textbox is selected
    }
    public void listBoxSelected() {
        // do whatever when listbox is selected
    }
    public void simulateUserIteraction() {
        listBox.setSelection("Arash Samandar");
        System.out.println(textBox.getContent());
    }
    // then in the MainMethod you would write :
    ArticlesObserverMediator articlesObserverMediator = new ArticlesObserverMediator();
    // articlesObserverMediator.simulateUserInteraction();
    // and you would see the results .
    // the rule of tump here is : don't forget to put the notifyAll() of the Observable
    // class , in the setSelection(String selection) method of the ListBox .
}
