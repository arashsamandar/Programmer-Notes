package refresh.strategy;

public class MainMethod {
    public static void main(String[] args) {
        String fileName = "samandar";
        var storeImage = new StoreImage(new JpegCompress(),new BlackAndWhiteFilter());
        storeImage.store(fileName);
    }
}
