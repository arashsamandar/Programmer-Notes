package refresh.usingEventHandler;

public class ListBox extends UIElement {
    private String listboxTitle;

    public String getListboxTitle() {
        return listboxTitle;
    }

    public void setListboxTitle(String listboxTitle) {
        this.listboxTitle = listboxTitle;
        notifyObservers();
    }
}
