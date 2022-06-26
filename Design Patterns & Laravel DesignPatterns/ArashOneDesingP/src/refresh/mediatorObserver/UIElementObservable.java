package refresh.mediatorObserver;

import java.util.ArrayList;
import java.util.List;

public class UIElementObservable {
    private List<EventHandler> eventHandlers = new ArrayList<>();

    public void addEventHandler(EventHandler eventHandler) {
        eventHandlers.add(eventHandler);
    }
    public void notifyEventHandlers() {
        for(var eventHandler : eventHandlers) {
            eventHandler.update();
        }
    }
}
