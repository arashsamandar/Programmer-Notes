package com.arash.tests.strategy;

public class BlackAndWhite implements Filter {
    @Override
    public void apply() {
        System.out.println("Black and white applied");
    }
}
