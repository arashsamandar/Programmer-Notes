package refresh.responses;

public class Compressor extends Handler {
    public Compressor(Handler next) {
        super(next);
    }
    public boolean doHandle(HTTPRequest request) {
        System.out.println("Compressing...");
        return false; // so next handler would be called.
    }
}
