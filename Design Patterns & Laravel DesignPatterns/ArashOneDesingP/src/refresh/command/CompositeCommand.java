package refresh.command;

import java.util.ArrayList;
import java.util.List;

public class CompositeCommand implements Command {
    private List<Command> commands = new ArrayList<>();
    public void addCommand(Command command) {
        commands.add(command);
    }
    public void execute() {
        for(var com : commands) {
            com.execute();
        }
    }
}
