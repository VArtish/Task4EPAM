package by.artish.text.chainofresposibility.impl;

import by.artish.text.chainofresposibility.AbstractTextComponentParser;
import by.artish.text.composite.TextComponent;
import by.artish.text.composite.TextComponentType;
import by.artish.text.composite.TextComposite;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParagraphParser extends AbstractTextComponentParser {
    private static final String SENTENCE_REGEX = ".+?[!?.…]";

    @Override
    public TextComponent handleRequest(String source) {
        TextComponent paragraphComponent = new TextComposite(TextComponentType.PARAGRAPH);
        Pattern sentencePattern = Pattern.compile(SENTENCE_REGEX);
        Matcher matcher = sentencePattern.matcher(source);
        while (matcher.find()) {
            String sentence = matcher.group().strip();
            paragraphComponent.add(successor.handleRequest(sentence));
        }
        return paragraphComponent;
    }
}
