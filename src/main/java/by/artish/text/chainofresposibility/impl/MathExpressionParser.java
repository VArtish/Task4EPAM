package by.artish.text.chainofresposibility.impl;


import by.artish.text.chainofresposibility.AbstractTextComponentParser;
import by.artish.text.composite.TextComponent;
import by.artish.text.composite.TextComponentType;
import by.artish.text.composite.TextComposite;
import by.artish.text.interpreter.converter.FromInfixToPostfixConverter;
import by.artish.text.interpreter.Client;
import by.artish.text.interpreter.context.Context;
import by.artish.text.interpreter.context.impl.ContextImpl;
import by.artish.text.interpreter.expression.AbstractMathExpression;

import java.util.List;

public class MathExpressionParser extends AbstractTextComponentParser {
    private final AbstractTextComponentParser successor = new SymbolParser();

    @Override
    public TextComponent handleRequest(String dataString) {
        TextComposite mathExpression = new TextComposite(TextComponentType.MATH_EXPRESSION);
        List<String> polishFormTokens = FromInfixToPostfixConverter.convert(dataString);
        List<AbstractMathExpression> expressions = Client.defineSequence(polishFormTokens);
        Context context = new ContextImpl();
        expressions.forEach(expression -> expression.interpret(context));
        dataString = context.popValue().toString();
        dataString.chars().forEach(symbol -> mathExpression.add(successor.handleRequest(Character.toString(symbol))));
        return mathExpression;
    }
}