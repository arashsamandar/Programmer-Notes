package refresh.responses;

public class MainMethod {
    public static void main(String[] args) {
        var compressor = new Compressor(null);
        var logger = new Logger(compressor);
        var authenticator = new Authenticator(logger);
        var server = new WebServer(authenticator);
        server.handle(new HTTPRequest("Arash","1234"));
    }
}
