package refresh.observerPushStyle;

public class ObserverTwo implements Observer {
    public void update(int value) {
        System.out.println("Observer Two Notified Update " + value);
    }
}
