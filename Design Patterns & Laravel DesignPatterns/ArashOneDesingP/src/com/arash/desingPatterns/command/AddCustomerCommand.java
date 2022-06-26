package com.arash.desingPatterns.command;

import com.arash.desingPatterns.command.fx.Command;

public class AddCustomerCommand implements Command {
    private AddCustomer service;
    public AddCustomerCommand(AddCustomer service) {
        this.service = service;
    }
    public void execute() {
        service.addCustomer();
    }
}
