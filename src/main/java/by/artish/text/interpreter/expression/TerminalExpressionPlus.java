package by.artish.text.interpreter.expression;

import by.artish.text.interpreter.context.Context;

public class TerminalExpressionPlus extends AbstractMathExpression {
    @Override
    public void interpret(Context context) {
        context.pushValue(context.popValue() + context.popValue());
    }
}
