package by.artish.text.service;

import by.artish.text.composite.TextComposite;

import java.util.List;

public interface SentenceFindService {
    List<TextComposite> findSentenceWithLongestWord(TextComposite text);
}
