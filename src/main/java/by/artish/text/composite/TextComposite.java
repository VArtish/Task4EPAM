package by.artish.text.composite;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TextComposite implements TextComponent {
    private List<TextComponent> components;
    private TextComponentType type;

    {
        components = new ArrayList<TextComponent>();
    }

    public TextComposite(TextComponentType type) {
        this.type = type;
    }

    @Override
    public List<TextComponent> getComponents() {
        return components;
    }

    @Override
    public TextComponentType getComponentType() {
        return this.type;
    }

    @Override
    public int size() {
        return components.size();
    }

    @Override
    public void add(TextComponent component) {
        components.add(component);
    }

    @Override
    public void addAll(List<TextComponent> components) {
        this.components.addAll(components);
    }

    @Override
    public void remove(TextComponent component) {
        components.remove(component);
    }

    @Override
    public Optional<TextComponent> getChild(int index) {
        TextComponent component = null;

        if (index < components.size()) {
            component = components.get(index);
        }

        return Optional.of(component);
    }

    @Override
    public String toString() {
        String result = type.getValue();
        for (TextComponent element : components) {
            result = result.concat(element.toString());
        }

        return result;
    }
}
