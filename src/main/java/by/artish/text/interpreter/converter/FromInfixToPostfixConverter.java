package by.artish.text.interpreter.converter;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class FromInfixToPostfixConverter {
    private static final String OPERATORS = "+-*/";
    private static final String DELIMITERS = "()";

    private FromInfixToPostfixConverter() {
    }

    public static List<String> convert(String infixForm) {
        List<String> postfixForm = new ArrayList<>();
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < infixForm.length(); i++) {
            Character current = infixForm.charAt(i);
            if (isDelimiter(current)) {
                if ("(".equals(current.toString())) {
                    stack.push(current);
                } else if (")".equals(current.toString())) {
                    while (!stack.peek().equals('(')) {
                        postfixForm.add(stack.pop().toString());
                    }
                    stack.pop();
                }
            } else if (isOperator(current)) {
                if (current.equals('-') && (i == 0 || '(' == infixForm.charAt(i - 1))) {
                    String number = readNumber(infixForm, i + 1);
                    postfixForm.add("0");
                    postfixForm.add(number);
                    postfixForm.add("-");
                    i += number.length();
                } else {
                    while (!stack.isEmpty() && priority(current) >= priority(stack.peek()) && !stack.peek().equals('(')) {
                        postfixForm.add(stack.pop().toString());
                    }

                    stack.push(current);
                }
            } else {
                String number = readNumber(infixForm, i);
                postfixForm.add(number);
                i += number.length() - 1;
            }
        }

        while (!stack.isEmpty()) {
            postfixForm.add(stack.pop().toString());
        }

        return postfixForm;
    }

    private static boolean isDelimiter(Character symbol) {
        return DELIMITERS.contains(symbol.toString());
    }

    private static boolean isOperator(Character symbol) {
        return OPERATORS.contains(symbol.toString());
    }

    private static int priority(Character symbol) {
        int priority = 3;
        if (symbol.equals('(') || symbol.equals(')')) {
            priority = 0;
        } else if (symbol.equals('*') || symbol.equals('/')) {
            priority = 1;
        } else if (symbol.equals('+') || symbol.equals('-')) {
            priority = 2;
        }

        return priority;
    }

    private static String readNumber(String infixForm, int from) {
        String number = "";
        while (infixForm.length() > from
                && !isDelimiter(infixForm.charAt(from))
                && !isOperator(infixForm.charAt(from))) {
            number = number.concat(Character.toString(infixForm.charAt(from)));
            from++;
        }

        return number;
    }

}