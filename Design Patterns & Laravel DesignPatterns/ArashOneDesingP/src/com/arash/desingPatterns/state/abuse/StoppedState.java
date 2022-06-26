package com.arash.desingPatterns.state.abuse;

public class StoppedState implements State {
    private StopWatch stopWatch;
    public StoppedState(StopWatch stopWatch) {
        this.stopWatch = stopWatch;
    }
    public void click() {
        stopWatch.setCurrentState(new RunningState(stopWatch));
        System.out.println("Running");
    }
}
