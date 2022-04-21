package by.artish.text.reader.impl;

import by.artish.text.exception.TextException;
import by.artish.text.reader.CustomFileReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CustomFileReaderImplTest {

    private final String pathToFile = "src/test/resources/file.txt";

    @Test
    public void testRead() throws TextException {
        CustomFileReader reader = new CustomFileReaderImpl();
        String actual = reader.read(pathToFile);
        String expected = "It has survived - not only (five) centuries, but also the leap into electronic typesetting,remaining -3-5 essentially 6*9/(3+4) unchanged. It was popularised in the 5*(1+2*(3/(4-(1-56-47)*73)+(-89+4/(42/7)))+1) with the release of Letraset sheets containing Lorem Ipsum passages,and more recently with desktop publishing software like Aldus PageMaker including versions ofLorem Ipsum.It is a long established fact that a reader will be distracted by the readable content of a pagewhen looking at its layout. The point of using (-71+(2+3/(3*(2+1/2+2)-2)/10+2))/7 Ipsum is that it hasa more-or-less normal distribution of letters, as opposed to using (Content here), content here',making it look like readable English.It is a (7+5*12*(2+5-2-71))/12 established fact that a reader will be of a page when lookingat its layout.Bye.";
        Assert.assertEquals(actual, expected);
    }
}