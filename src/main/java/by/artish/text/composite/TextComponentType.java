package by.artish.text.composite;

public enum TextComponentType {
    TEXT(""),
    PARAGRAPH("\t\n"),
    SENTENCE(""),
    LEXEME("\u0020"),
    WORD(""),
    SYMBOL(""),
    MATH_EXPRESSION("");

    private final String value;

    TextComponentType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
