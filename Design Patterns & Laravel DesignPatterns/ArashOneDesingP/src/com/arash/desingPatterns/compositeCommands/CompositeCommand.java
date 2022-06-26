package com.arash.desingPatterns.compositeCommands;

import com.arash.desingPatterns.command.fx.Command;

import java.util.ArrayList;
import java.util.List;

public class CompositeCommand implements Command {
    private List<Command> commands = new ArrayList<>();
    public void add(Command command) {
        commands.add(command);
    }
    public void execute() {
        for(var command : commands) {
            command.execute();
        }
    }
}
