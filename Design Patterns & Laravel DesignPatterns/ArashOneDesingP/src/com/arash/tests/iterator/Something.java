package com.arash.tests.iterator;

import java.util.ArrayList;
import java.util.List;

public class Something {
    private List<String> urls = new ArrayList<>();
    public void push(String url) {
        urls.add(url);
    }
    public String pop() {
        int lastIndex = urls.size() -1;
        var lastItem = urls.get(lastIndex);
        urls.remove(lastItem);
        return lastItem;
    }
    public Iterator createIterator() {
        return new SomethingIterator(this);
    }


    public class SomethingIterator implements Iterator {
        private Something something;
        int index;
        public SomethingIterator(Something something){
            this.something = something;
        }
        public void next() {
            index++;
        }
        public boolean hasNext() {
            return (index < something.urls.size());
        }
        public String current() {
            return something.urls.get(index);
        }
    }
}
