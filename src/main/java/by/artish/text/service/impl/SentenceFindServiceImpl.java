package by.artish.text.service.impl;

import by.artish.text.composite.TextComponent;
import by.artish.text.composite.TextComponentType;
import by.artish.text.composite.TextComposite;
import by.artish.text.service.SentenceFindService;

public class SentenceFindServiceImpl implements SentenceFindService {
    @Override
    public TextComposite findSentenceWithLongestWord(TextComposite text) {
        TextComposite resultSentence = new TextComposite(TextComponentType.SENTENCE);
        String longestWord = "";
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
                                    String word = lexemPartComposite.toString();
                                    if (word.length() > longestWord.length()) {
                                        longestWord = word;
                                        resultSentence = sentence;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        return resultSentence;
    }


}
