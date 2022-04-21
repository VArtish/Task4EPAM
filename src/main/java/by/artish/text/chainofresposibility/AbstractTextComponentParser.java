package by.artish.text.chainofresposibility;

import by.artish.text.composite.TextComponent;

public abstract class AbstractTextComponentParser {
    protected AbstractTextComponentParser successor;

    public AbstractTextComponentParser() {
    }

    public void setNextSuccessor(AbstractTextComponentParser successor) {
        this.successor = successor;
    }

    public abstract TextComponent handleRequest(String source);
}
