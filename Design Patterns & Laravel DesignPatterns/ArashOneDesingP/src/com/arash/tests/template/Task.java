package com.arash.tests.template;

public abstract class Task {
    private AuditTrail auditTrail;
    public Task(AuditTrail auditTrail) {
        this.auditTrail = auditTrail;
    }

    public void doBankingOperation() {
        auditTrail.record();
        doExecute(); // Transfers Money.
    }

    protected abstract void doExecute();

}
