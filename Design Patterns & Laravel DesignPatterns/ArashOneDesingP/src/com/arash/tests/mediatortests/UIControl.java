package com.arash.tests.mediatortests;

import java.util.ArrayList;
import java.util.List;

public abstract class UIControl {
    // in here it is the Mediator-Abstract
    private List<EventHandler> eventHandlerList = new ArrayList<>();
    public void addEventHandler(EventHandler handler) {
        eventHandlerList.add(handler);
    }
    protected void notifyHandlers() {
        for(var ev : eventHandlerList) {
            ev.handle();
        }
    }
}
