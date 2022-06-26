package refresh.mediatorRerefresh;

public class ListBox extends Element {
    private String listBoxTitle;
    public ListBox(Mediator mediator) {
        super(mediator);
    }

    public String getListBoxTitle() {
        return listBoxTitle;
    }

    public void setListBoxTitle(String listBoxTitle) {
        this.listBoxTitle = listBoxTitle;
        mediator.changed(this);
    }
}
