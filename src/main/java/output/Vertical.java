package output;

import java.util.List;
import java.util.stream.Collectors;

public class Vertical implements Output {
    @Override
    public String output(List<String> words) {
        return words.stream().collect(Collectors.joining("\n"));
    }
}
