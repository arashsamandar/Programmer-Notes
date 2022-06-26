package com.arash.desingPatterns.template;

public abstract class Task {
    private GenerateReportTask reportTask;
    private AuditTrail auditTrail;
    public Task() {
        auditTrail = new AuditTrail();
    }
    public void execute() {
        auditTrail.record();
        doExecute();
        reportTask.execute();
    }

    protected abstract void doExecute();
}
