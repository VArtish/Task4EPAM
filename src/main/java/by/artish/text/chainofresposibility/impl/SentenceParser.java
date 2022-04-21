package by.artish.text.chainofresposibility.impl;

import by.artish.text.chainofresposibility.AbstractTextComponentParser;
import by.artish.text.composite.*;

public class SentenceParser extends AbstractTextComponentParser {
    private static final String SENTENCE_REGEX = " ";

    @Override
    public TextComponent handleRequest(String source) {
        TextComponent sentenceComponent = new TextComposite(TextComponentType.SENTENCE);
        String[] words = source.split(SENTENCE_REGEX);
        for (String word : words) {
            TextComponent textComponent = successor.handleRequest(word);
            sentenceComponent.add(textComponent);
        }

        return sentenceComponent;
    }
}
