package by.artish.text.reader.impl;

import by.artish.text.exception.TextException;
import by.artish.text.reader.CustomFileReader;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CustomFileReaderImpl implements CustomFileReader {
    private static final Logger LOGGER = LogManager.getLogger(CustomFileReaderImpl.class);

    @Override
    public String read(String path) throws TextException {
        String text = "";
        try (FileReader reader = new FileReader(path);
             BufferedReader bufferedReader = new BufferedReader(reader)) {
            while (bufferedReader.ready()) {
                text = text.concat(bufferedReader.readLine());
            }
        } catch (IOException e) {
            LOGGER.log(Level.ERROR, e);
            throw new TextException(e);
        }
        return text;
    }
}