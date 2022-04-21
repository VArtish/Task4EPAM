package by.artish.text.interpreter.expression;

import by.artish.text.interpreter.context.Context;

public class NonterminalExpressionNumber extends AbstractMathExpression {
    private double number;

    public NonterminalExpressionNumber(double number) {
        this.number = number;
    }

    @Override
    public void interpret(Context context) {
        context.pushValue(number);
    }
}
