package com.arash.desingPatterns.iterator;

import java.util.ArrayList;
import java.util.List;

public class BrowseHistory {
    private List<String> urls = new ArrayList<>();
    public void push(String url) {urls.add(url);}
    public String pop() {
        var lastIndex = urls.size() - 1;
        var lastUrl = urls.get(lastIndex);
        urls.remove(lastUrl);
        return lastUrl;
    }
    public Iterator createIterator() {
        return new ListIterator(this);
    }

    public class ListIterator implements Iterator {
        private BrowseHistory history;
        private int index;
        public ListIterator(BrowseHistory history) {
            this.history = history;
        }

        public boolean hasNext() {
            return (index < history.urls.size());
        }
        public String current() {
            return history.urls.get(index);
        }
        public void next() {
            index++;
        }
    }
}
