package by.artish.text.service.impl;

import by.artish.text.composite.TextComposite;
import by.artish.text.service.TextFormatService;
import org.w3c.dom.Text;

public class TextFormatServiceImpl implements TextFormatService {
    @Override
    public void removeSentenceThan(TextComposite text, int length) {
        for(int i = 0; i < text.size(); i++) {
            TextComposite paragraph = (TextComposite) text.getChild(i).get();
            for(int j = 0; j < paragraph.size(); j++) {
                TextComposite sentence = (TextComposite) paragraph.getChild(j).get();
                if(sentence.size() < length) {
                    paragraph.remove(sentence);
                    j--;
                }
            }
        }
        for(int i = 0; i < text.size(); i++) {
            TextComposite paragraph = (TextComposite) text.getChild(i).get();
            if(paragraph.size() == 0) {
                text.remove(paragraph);
            }
        }
    }
}
