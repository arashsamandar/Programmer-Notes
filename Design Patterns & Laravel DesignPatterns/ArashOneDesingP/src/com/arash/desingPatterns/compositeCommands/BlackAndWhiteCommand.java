package com.arash.desingPatterns.compositeCommands;

import com.arash.desingPatterns.command.fx.Command;

public class BlackAndWhiteCommand implements Command {
    @Override
    public void execute() {
        System.out.println("Black And White");
    }
}
