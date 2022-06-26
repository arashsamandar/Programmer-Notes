package refresh.command;

public class CustomerServiceCommand implements Command {
    private CustomerServiceAction customerServiceAction;

    public CustomerServiceCommand(CustomerServiceAction action) {
        this.customerServiceAction = action;
    }

    public void execute() {
        customerServiceAction.action();
    }
}
