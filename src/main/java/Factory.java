import convert.Capitalize;
import convert.Compress;
import convert.Convert;
import convert.Reverse;
import output.Horizontal;
import output.Output;

import java.util.Arrays;
import java.util.List;

public class Factory {
    public static void factory(List<String> inputs) {
        List<String> word = Arrays.asList(inputs.get(0).split(" "));

        inputs.forEach(rule -> convertFactory(word, rule));
        //todo:戻り値戻ってこないからどうしよ

    }

    public static List<String> convertFactory(List<String> words, String rule) {
        Convert convert = new Capitalize();
        if (rule.equals("--capitalize")) {
            convert = new Capitalize();
        }
        if (rule.equals("--compress")) {
            convert = new Compress();
        }
        if (rule.equals("--reverse")) {
            convert = new Reverse();
        }
        return convert.convert(words);
    }

    public static Output outputFactory(List<String> words, String rules) {
        Output output;
        if (rules.equals("--horizontal")) {
            output = new Horizontal();
        }
        return null;
    }
}
