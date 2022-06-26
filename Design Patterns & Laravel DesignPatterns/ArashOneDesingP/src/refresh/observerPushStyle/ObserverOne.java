package refresh.observerPushStyle;

public class ObserverOne implements Observer {
    public void update(int value) {
        System.out.println("Observer One Update Notified " + value);
    }
}
