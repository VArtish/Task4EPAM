package by.artish.text.reader;

import by.artish.text.exception.TextException;

public interface CustomFileReader {
    String read(String path) throws TextException;
}