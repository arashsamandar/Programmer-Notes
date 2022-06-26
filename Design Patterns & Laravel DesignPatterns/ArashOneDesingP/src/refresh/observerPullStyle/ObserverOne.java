package refresh.observerPullStyle;

public class ObserverOne implements Observer {
    private ObservableClass observableClass;
    public ObserverOne(ObservableClass observableClass) {
        this.observableClass = observableClass;
    }
    public void update() {
        System.out.println("Observer One Update Notified " +
                observableClass.getValue());
    }
}
