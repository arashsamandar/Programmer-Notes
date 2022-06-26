package refresh.observerPullStyle;

public class MainClass {
    public static void main(String[] args) {
        var observableClass = new ObservableClass();
        observableClass.addObserver(new ObserverOne(observableClass));
        observableClass.addObserver(new ObserverTwo(observableClass));
        observableClass.setValue(10);
    }
}
