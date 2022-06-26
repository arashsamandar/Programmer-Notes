package refresh.usingEventHandler;

import java.util.ArrayList;
import java.util.List;

public abstract class UIElement {
    private List<Observer> observers = new ArrayList<>();
    public void attach(Observer observer) {
        observers.add(observer);
    }
    protected void notifyObservers() {
        for(var observer : observers) {
            observer.update();
        }
    }
}
