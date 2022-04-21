package by.artish.text.interpreter.expression;

import by.artish.text.interpreter.context.Context;

public class TerminalExpressionMultiply extends AbstractMathExpression {
    @Override
    public void interpret(Context context) {
        context.pushValue(context.popValue() * context.popValue());
    }
}
