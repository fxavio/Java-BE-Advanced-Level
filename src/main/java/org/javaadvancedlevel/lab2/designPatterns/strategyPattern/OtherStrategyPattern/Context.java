package org.javaadvancedlevel.lab2.designPatterns.strategyPattern.OtherStrategyPattern;

public class Context {
    private final Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public float executeStrategy(float a, float b) {
        return strategy.calculation(a, b);
    }
}
