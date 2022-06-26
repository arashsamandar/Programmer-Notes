package com.arash.tests.mediator;

public class ArticlesDialogBox extends DialogBox {
    private Button button = new Button(this);

    /**
     * we can do this cause in the UIControl we have a composition
     * relation of the DialogBox , and then the Button inherits the UIContorl
     * and over here on the DialogBox we have a relation to UIControl in the
     * change method
     */
    public void change(UIControl uiControl) {
        if(uiControl == button) {
            // do whatever .
            // or call the other UIControll element .
        }
    }
}
