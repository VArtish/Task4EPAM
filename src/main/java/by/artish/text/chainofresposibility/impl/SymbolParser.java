package by.artish.text.chainofresposibility.impl;

import by.artish.text.chainofresposibility.AbstractTextComponentParser;
import by.artish.text.composite.Symbol;
import by.artish.text.composite.TextComponent;
import by.artish.text.composite.TextComponentType;

public class SymbolParser extends AbstractTextComponentParser {
    @Override
    public TextComponent handleRequest(String source) {
        TextComponent symbolComponent = new Symbol(source.charAt(0), TextComponentType.SYMBOL);
        return symbolComponent;
    }
}
