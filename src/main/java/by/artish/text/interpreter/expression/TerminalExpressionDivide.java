package by.artish.text.interpreter.expression;

import by.artish.text.interpreter.context.Context;

public class TerminalExpressionDivide extends AbstractMathExpression {
    @Override
    public void interpret(Context context) {
        double subtrahend = context.popValue();
        double minuend = context.popValue();
        context.pushValue(minuend / subtrahend);
    }
}
