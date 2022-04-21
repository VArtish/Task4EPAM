package by.artish.text.composite;

import java.util.List;
import java.util.Optional;

public interface TextComponent {
    TextComponentType getComponentType();

    List<TextComponent> getComponents();

    int size();

    void add(TextComponent component);

    void addAll(List<TextComponent> components);

    void remove(TextComponent component);

    Optional<TextComponent> getChild(int index);
}
