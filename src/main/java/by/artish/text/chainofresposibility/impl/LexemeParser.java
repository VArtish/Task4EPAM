package by.artish.text.chainofresposibility.impl;

import by.artish.text.chainofresposibility.AbstractTextComponentParser;
import by.artish.text.composite.*;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LexemeParser extends AbstractTextComponentParser {
    private static final String MATH_EXPRESSION_REGEX = "[\\d+\\-*/()]{3,}";
    private final AbstractTextComponentParser mathOperationParser = new MathExpressionParser();

    @Override
    public TextComponent handleRequest(String source) {
        TextComposite lexemeComponent = new TextComposite(TextComponentType.LEXEME);
        List<TextComponent> symbols = new ArrayList<TextComponent>();
        String newWord = checkSymbol(symbols, source);
        if (!newWord.isEmpty()) {
            TextComponent wordComponent = successor.handleRequest(newWord);
            Pattern mathOperation = Pattern.compile(MATH_EXPRESSION_REGEX);
            Matcher mathMatcher = mathOperation.matcher(newWord);
            if (mathMatcher.matches()) {
                lexemeComponent.add(mathOperationParser.handleRequest(newWord));
            } else {
                lexemeComponent.add(wordComponent);
            }
        }
        if (!symbols.isEmpty()) {
            lexemeComponent.addAll(symbols);
        }


        return lexemeComponent;
    }

    private String checkSymbol(List<TextComponent> symbols, String word) {
        String newWord = new String();
        for (int i = 0; i < word.length() - 1; i++) {
            boolean addFlag = true;
            if (SymbolType.isSymbol(word.charAt(i))) {
                if (SymbolType.isSymbol((word.charAt(i + 1)))) {
                    addFlag = false;
                    symbols.add(new Symbol(word.charAt(i), TextComponentType.SYMBOL));
                }
            }
            if (addFlag) {
                newWord += word.charAt(i);
            }
        }
        if (SymbolType.isSymbol(word.charAt(word.length() - 1))) {
            symbols.add(new Symbol(word.charAt(word.length() - 1), TextComponentType.SYMBOL));
        } else {
            newWord += word.charAt(word.length() - 1);
        }

        return newWord;
    }
}
