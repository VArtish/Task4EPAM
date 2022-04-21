package by.artish.text.composite;

public enum SymbolType {
    COMMA(','),
    DOT('.'),
    QUESTION_MARK('?'),
    EXCLAMATION_MARK('!');
    private Character symbol;

    SymbolType(Character symbol) {
        this.symbol = symbol;
    }

    public static boolean isSymbol(Character symbol) {
        boolean flag = false;
        for (SymbolType symbolType : SymbolType.values()) {
            if (symbolType.symbol.equals(symbol)) {
                flag = true;
            }
        }

        return flag;
    }
}
