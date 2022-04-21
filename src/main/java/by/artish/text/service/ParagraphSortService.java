package by.artish.text.service;

import by.artish.text.composite.TextComponent;
import by.artish.text.composite.TextComposite;

import java.util.Comparator;

public interface ParagraphSortService {
    void sort(TextComposite text, Comparator<TextComponent> comparator);
}
