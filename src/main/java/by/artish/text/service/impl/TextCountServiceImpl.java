package by.artish.text.service.impl;

import by.artish.text.composite.TextComponent;
import by.artish.text.composite.TextComponentType;
import by.artish.text.composite.TextComposite;
import by.artish.text.service.TextCountService;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class TextCountServiceImpl implements TextCountService {
    @Override
    public Map<String, Integer> countWords(TextComposite text) {
        Map<String, Integer> result = new HashMap<>();
        if (text.getComponentType() == TextComponentType.TEXT) {
            for (int i = 0; i < text.size(); i++) {
                TextComponent paragraphComponent = text.getChild(i).get();
                TextComposite paragraph = (TextComposite) paragraphComponent;
                for (int j = 0; j < paragraph.size(); j++) {
                    TextComposite sentence = (TextComposite) paragraph.getChild(j).get();
                    for (int k = 0; k < sentence.size(); k++) {
                        TextComponent lexema = sentence.getChild(k).get();
                        if (lexema.getClass() == TextComposite.class) {
                            TextComposite lexemaComposite = (TextComposite) lexema;
                            for (int z = 0; z < lexemaComposite.size(); z++) {
                                TextComponent lexemPart = lexemaComposite.getChild(z).get();
                                if (lexemPart instanceof TextComposite) {
                                    TextComposite lexemPartComposite = (TextComposite) lexemPart;
                                    if (lexemPartComposite.getComponentType() == TextComponentType.WORD) {
                                        String word = lexemPartComposite.toString().toLowerCase(Locale.ROOT);
                                        result.computeIfPresent(word, (key, value) -> ++value);
                                        result.putIfAbsent(word, 1);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        return result;
    }
}
