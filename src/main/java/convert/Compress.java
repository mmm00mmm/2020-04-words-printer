package convert;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Compress implements Convert {
    @Override
    public List<String> convert(List<String> words) {
        return words.stream()
                .map(this::compress)
                .collect(Collectors.toList());
    }

    private String compress(String word) {
        String result = "";
        List<String> wordList = Arrays.asList(word.split(""));

        for (int i = wordList.size() - 1; 0 < i; i--) {
            if (!wordList.get(i).equals(wordList.get(i - 1))) {
                result = wordList.get(i) + result;
            }
        }
        return wordList.get(0) + result;
    }
}
