package by.artish.text.service.impl;

import by.artish.text.composite.TextComponent;
import by.artish.text.composite.TextComponentType;
import by.artish.text.composite.TextComposite;
import by.artish.text.service.ParagraphSortService;

import java.util.Collections;
import java.util.Comparator;

public class ParagraphSortServiceImpl implements ParagraphSortService {
    @Override
    public void sort(TextComposite text, Comparator<TextComponent> comparator) {
        if (text.getComponentType() == TextComponentType.TEXT) {
            Collections.sort(text.getComponents(), comparator);
        }
    }
}
