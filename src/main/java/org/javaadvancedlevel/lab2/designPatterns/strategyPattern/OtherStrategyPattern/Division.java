package org.javaadvancedlevel.lab2.designPatterns.strategyPattern.OtherStrategyPattern;

public class Division implements Strategy {
    @Override
    public float calculation(float a, float b) {
        return a / b;
    }
}
