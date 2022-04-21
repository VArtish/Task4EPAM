package by.artish.text.interpreter.context;

public interface Context {
    Double popValue();

    void pushValue(Double value);
}
