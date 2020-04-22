package convert;

import java.util.List;
import java.util.stream.Collectors;

public class Capitalize implements Convert {
    @Override
    public List<String> convert(List<String> words) {
        //todo:Listが空文字だった場合
        return words.stream()
                .map(s -> s.substring(0, 1).toUpperCase() + s.substring(1).toLowerCase())
                .collect(Collectors.toList());
    }
}
