package com.arash.desingPatterns.command;

import com.arash.desingPatterns.command.fx.Button;

public class MainMethod {
    public static void main(String[] args) {
        var customerService = new AddCustomer();
        var addCustomerCommand = new AddCustomerCommand(customerService);
        var button = new Button(addCustomerCommand);
        button.click();
    }
}
