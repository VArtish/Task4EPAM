package by.artish.text.service.impl;

import by.artish.text.composite.TextComponent;
import by.artish.text.composite.TextComponentType;
import by.artish.text.composite.TextComposite;
import by.artish.text.service.SentenceFindService;

import java.util.ArrayList;
import java.util.List;

public class SentenceFindServiceImpl implements SentenceFindService {
    @Override
    public List<TextComposite> findSentenceWithLongestWord(TextComposite text) {
        String longestWord = findLongestWord(text);
        List<TextComposite> list = findSentence(text, longestWord.length());
        return list;
    }

    private List<TextComposite> findSentence(TextComposite text, int lengthLongestWord) {
        List<TextComposite> list = new ArrayList<TextComposite>();
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
                                    if (word.length() == lengthLongestWord) {
                                        if (!list.contains(sentence)) {
                                            list.add(sentence);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        return list;
    }

    private String findLongestWord(TextComposite text) {
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
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        return longestWord;
    }


}
