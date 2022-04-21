package by.artish.text.chainofresposibility.impl;

import by.artish.text.chainofresposibility.AbstractTextComponentParser;
import by.artish.text.composite.TextComponent;
import by.artish.text.composite.TextComponentType;
import by.artish.text.composite.TextComposite;

public class TextParser extends AbstractTextComponentParser {
    private static final String TEXT_REGEX = "\n";

    @Override
    public TextComponent handleRequest(String source) {
        TextComponent textComponent = new TextComposite(TextComponentType.TEXT);
        String[] paragraphs = source.split(TEXT_REGEX);
        for (String paragraph : paragraphs) {
            TextComponent paragraphComponent = successor.handleRequest(paragraph);
            textComponent.add(paragraphComponent);
        }

        return textComponent;
    }
}
