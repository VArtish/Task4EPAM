package by.artish.text.interpreter.context.impl;

import by.artish.text.interpreter.context.Context;

import java.util.ArrayDeque;

public class ContextImpl implements Context {
    private ArrayDeque<Double> values;

    {
        values = new ArrayDeque<Double>();
    }

    public Double popValue() {
        return values.pop();
    }

    public void pushValue(Double value) {
        values.push(value);
    }
}
