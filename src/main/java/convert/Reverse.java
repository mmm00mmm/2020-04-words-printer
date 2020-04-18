package convert;

import java.util.Collections;
import java.util.List;

public class Reverse implements Convert {
    @Override
    public List<String> convert(List<String> words) {
        Collections.reverse(words);
        return words;
    }
}
