package refresh.strategy;

public class JpegCompress implements ImageCompressor {
    public void compress(String filename) {
        System.out.println( filename + " IS Compressed with JPEG Format");
    }
}
