package refresh.responses;

public class Authenticator extends Handler {
    public Authenticator(Handler next) {
        super(next);
    }
    public boolean doHandle(HTTPRequest request) {
        var isValid = (request.getPassword() == "1234"
        && request.getUsername() == "Arash");
        System.out.println("Authneticating...");
        return !isValid;
    }
}
