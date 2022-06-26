package refresh.command;

public class Button {
    private Command command;
    public void click() {
        command.execute();
    }

    public Button(Command command) {
        this.command = command;
    }
}
