package by.artish.text.composite;

import java.util.List;
import java.util.Optional;

public class Symbol implements TextComponent {
    private char symbol;
    private TextComponentType type;

    public Symbol(char symbol, TextComponentType type) {
        this.symbol = symbol;
        this.type = type;
    }

    @Override
    public List<TextComponent> getComponents() {
        throw new UnsupportedOperationException("It's a leaf!");
    }

    @Override
    public int size() {
        return 1;
    }

    @Override
    public TextComponentType getComponentType() {
        return this.type;
    }

    @Override
    public void add(TextComponent component) {
        throw new UnsupportedOperationException("It's a leaf!");
    }

    @Override
    public void addAll(List<TextComponent> components) {
        throw new UnsupportedOperationException("It's a leaf!");
    }

    @Override
    public void remove(TextComponent component) {
        throw new UnsupportedOperationException("It's a leaf!");
    }

    @Override
    public Optional<TextComponent> getChild(int index) {
        throw new UnsupportedOperationException("It's a leaf!");
    }

    @Override
    public String toString() {
        return String.valueOf(symbol);
    }
}
