package comparator;

import by.artish.text.composite.TextComponent;

import java.util.Comparator;

public class ParagraphComparator implements Comparator<TextComponent> {
    @Override
    public int compare(TextComponent o1, TextComponent o2) {
        int result = Integer.compare(o1.size(), o2.size());
        return result;
    }
}