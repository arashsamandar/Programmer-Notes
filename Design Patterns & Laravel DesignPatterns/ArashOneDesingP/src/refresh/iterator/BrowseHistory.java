package refresh.iterator;

import java.util.ArrayList;
import java.util.List;

public class BrowseHistory {
    private List<String> urls = new ArrayList<>();
    public void push(String url) {
        urls.add(url);
    }
    public String pop() {
        var lastIndex = urls.size() - 1;
        var lastUrl = urls.get(lastIndex);
        urls.remove(lastUrl);

        return lastUrl;
    }
    // Exactly like what you have created before for the Fragments
    // Fragments Iterator for Android . this is it
    public Iterator createIterator() {
        return new BrowserIterator(this);
    }

    public class BrowserIterator implements Iterator {
        private BrowseHistory history;
        private int index;

        public BrowserIterator(BrowseHistory history) {
            this.history = history;
        }

        public boolean hastNext() {
            return (history.urls.size() > index);
        }

        public void next() {
            index++;
        }

        public String current() {
            return (history.urls.get(index));
        }
    }
}
