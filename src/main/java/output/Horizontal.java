package output;

import java.util.List;
import java.util.stream.Collectors;

public class Horizontal implements Output {
    @Override
    public String output(List<String> word) {
        return word.stream().collect(Collectors.joining(" "));
    }
}
