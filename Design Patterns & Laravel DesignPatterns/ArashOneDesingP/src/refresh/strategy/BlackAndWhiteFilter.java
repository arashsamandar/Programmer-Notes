package refresh.strategy;

public class BlackAndWhiteFilter implements ImageFilter {
    public void filter(String filename) {
        System.out.println(filename + " IS Filtered with Black And White");
    }
}
