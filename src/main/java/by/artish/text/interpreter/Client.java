package by.artish.text.interpreter;

import by.artish.text.interpreter.expression.*;

import java.util.*;

public class Client {
    public static List<AbstractMathExpression> defineSequence(List<String> polishNotationTokens) {
        List<AbstractMathExpression> expressions = new ArrayList<>();
        for (String token : polishNotationTokens) {
            switch (token) {
                case (MathOperation.PLUS) -> {
                    expressions.add(new TerminalExpressionPlus());
                }
                case (MathOperation.MINUS) -> {
                    expressions.add(new TerminalExpressionMinus());
                }
                case (MathOperation.DIVIDE) -> {
                    expressions.add(new TerminalExpressionDivide());
                }
                case (MathOperation.MULTIPLY) -> {
                    expressions.add(new TerminalExpressionMultiply());
                }
                default -> {
                    expressions.add(new NonterminalExpressionNumber(Double.parseDouble(token)));
                }
            }
        }
        return expressions;
    }
}
