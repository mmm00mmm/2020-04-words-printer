import convert.Capitalize;
import convert.Compress;
import convert.Reverse;
import output.Horizontal;
import output.Vertical;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Executor {
    static String run(List<String> strings) {
        List<String> words = Arrays.asList(strings.get(0).split(" "));
        List<String> rules = strings.stream().skip(1).collect(Collectors.toList());

        List<String> convertRules = rules.stream()
                .filter(rule -> Arrays.asList("--capitalize", "--compress", "--reverse").contains(rule))
                .collect(Collectors.toList());

        if (convertRules.isEmpty()) {
            throw new RuntimeException("変換引数不正");
        } else if (convertRules.stream().distinct().count() != convertRules.size()) {
            throw new RuntimeException("同じ変換引数が２つ以上指定されている");
        } else {
            //Do Nothing
        }

        List<String> outputRules = rules.stream()
                .filter(rule -> Arrays.asList("--horizontal", "--vertical").contains(rule))
                .collect(Collectors.toList());

        if (outputRules.isEmpty()) {
            throw new RuntimeException("出力引数不正");
        } else if (outputRules.size() > 1) {
            throw new RuntimeException("引数が2つ以上");
        } else {
            //Do Nothing
        }

        //assert outputRules.isEmpty(),"引数不正"; //todo:調べる

        for (String convertRule : convertRules) {
            words = convertFactory(words, convertRule);
        }

        return outputFactory(words, outputRules.get(0));
    }

    private static List<String> convertFactory(List<String> words, String convertRule) {
        if (convertRule.equals("--capitalize")) {
            return new Capitalize().convert(words);
        } else if (convertRule.equals("--compress")) {
            return new Compress().convert(words);
        } else if (convertRule.equals("--reverse")) {
            return new Reverse().convert(words);
        } else {
            throw new RuntimeException("変換引数入力エラー");
        }
    }

    private static String outputFactory(List<String> words, String outputRule) {
        if (outputRule.equals("--horizontal")) {
            return new Horizontal().output(words);
        } else if (outputRule.equals("--vertical")) {
            return new Vertical().output(words);
        } else {
            throw new RuntimeException("出力引数入力エラー");
        }
    }
}
