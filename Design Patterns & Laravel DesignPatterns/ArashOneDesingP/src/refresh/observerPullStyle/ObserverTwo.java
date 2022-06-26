package refresh.observerPullStyle;

public class ObserverTwo implements Observer {
    private ObservableClass observableClass;

    public ObserverTwo(ObservableClass observableClass) {
        this.observableClass = observableClass;
    }

    public void update() {
        System.out.println("Observer Two Notified Update " +
                observableClass.getValue());
    }
}
