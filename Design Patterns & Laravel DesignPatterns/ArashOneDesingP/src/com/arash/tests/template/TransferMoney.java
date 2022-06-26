package com.arash.tests.template;

public class TransferMoney extends Task {
    public TransferMoney(AuditTrail auditTrail) {
        super(auditTrail);
    }
    protected void doExecute() {
        System.out.println("Money Transferred");
    }
}
