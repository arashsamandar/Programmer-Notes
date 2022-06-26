package com.arash.tests.tteesst;

import java.util.ArrayList;
import java.util.List;

public abstract class Observable {
    private List<EventHandler> eventHandlers = new ArrayList<>();
    public void addEventHandler(EventHandler eventHandler) {
        eventHandlers.add(eventHandler);
    }
    public void notifyObservers() {
        for(var eventHandler : eventHandlers) {
            eventHandler.handle();
        }
    }
}
