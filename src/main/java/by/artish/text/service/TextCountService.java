package by.artish.text.service;

import by.artish.text.composite.TextComposite;

import java.util.Map;

public interface TextCountService {
    Map<String, Integer> countWords(TextComposite text);
}
