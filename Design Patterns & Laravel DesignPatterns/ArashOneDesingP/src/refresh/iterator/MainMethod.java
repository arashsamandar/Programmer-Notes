package refresh.iterator;

import java.rmi.UnexpectedException;

public class MainMethod {
    public static void main(String[] args) {
        var history = new BrowseHistory();
        history.push("Arash");
        history.push("samandar");
        history.push("havij");
        Iterator iterator = history.createIterator();
        while(iterator.hastNext()) {
            var url = iterator.current();
            System.out.println(url);
            iterator.next();
        }
    }
}
