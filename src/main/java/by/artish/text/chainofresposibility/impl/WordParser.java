package by.artish.text.chainofresposibility.impl;

import by.artish.text.chainofresposibility.AbstractTextComponentParser;
import by.artish.text.composite.TextComponent;
import by.artish.text.composite.TextComponentType;
import by.artish.text.composite.TextComposite;

public class WordParser extends AbstractTextComponentParser {

    @Override
    public TextComponent handleRequest(String source) {
        TextComponent wordComponent = new TextComposite(TextComponentType.WORD);
        char[] symbols = source.toCharArray();
        for (Character symbol : symbols) {
            TextComponent symbolComponent = successor.handleRequest(symbol.toString());
            wordComponent.add(symbolComponent);
        }

        return wordComponent;
    }
}
