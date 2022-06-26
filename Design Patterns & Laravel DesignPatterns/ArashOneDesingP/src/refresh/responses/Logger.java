package refresh.responses;

public class Logger extends Handler {
    public Logger(Handler next) {
        super(next);
    }
    public boolean doHandle(HTTPRequest request) {
        System.out.println("Logging...");
        return false;
    }
}
