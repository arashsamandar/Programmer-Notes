package refresh.observerPushStyle;

public class MainClass {
    public static void main(String[] args) {
        var observableClass = new ObservableClass();
        observableClass.addObserver(new ObserverOne());
        observableClass.addObserver(new ObserverTwo());
        observableClass.setValue(10);
    }
}
