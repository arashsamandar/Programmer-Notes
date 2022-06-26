package refresh.strategy;

public class StoreImage {
    private ImageCompressor compressor;
    private ImageFilter filter;

    public StoreImage(ImageCompressor compressor,ImageFilter filter) {
        this.compressor = compressor;
        this.filter = filter;
    }

    public void store(String fileName) {
        compressor.compress(fileName);
        filter.filter(fileName);
    }
}
