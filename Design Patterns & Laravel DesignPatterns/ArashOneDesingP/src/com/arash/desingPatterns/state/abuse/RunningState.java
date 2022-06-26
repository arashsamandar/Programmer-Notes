package com.arash.desingPatterns.state.abuse;

public class RunningState implements State {
    private StopWatch stopWatch;
    public RunningState(StopWatch stopWatch) {
        this.stopWatch = stopWatch;
    }
    public void click() {
        stopWatch.setCurrentState(new StoppedState(stopWatch));
        System.out.println("Stopped");
    }
}
