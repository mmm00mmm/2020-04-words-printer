import convert.Capitalize;
import convert.Compress;
import convert.Convert;
import convert.Reverse;
import output.Horizontal;
import output.Output;
import output.Vertical;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Factory {
    public static void create(List<String> strings) {
        List<String> words = Arrays.asList(strings.get(0).split(" "));
        List<String> rules = strings.stream().skip(1).collect(Collectors.toList());

        for (String convertRule : rules) {
            words = convertFactory(words, convertRule);
        }

        for (String outputRule : rules) {
            System.out.println(outputFactory(words, outputRule));
        }
    }

    private static List<String> convertFactory(List<String> words, String convertRule) {
        Convert convert = new Capitalize();
        //fixme: 初期値がCapitalizeなので、ifに該当しなくても勝手に変換される

        if (convertRule.equals("--capitalize")) {
            convert = new Capitalize();
        }
        if (convertRule.equals("--compress")) {
            convert = new Compress();
        }
        if (convertRule.equals("--reverse")) {
            convert = new Reverse();
        }
        return convert.convert(words);
    }

    private static String outputFactory(List<String> words, String outputRule) {
        Output output = new Horizontal();
        //fixme: 初期値がHorizontalなので、ifに該当しなくても勝手に出力される

        if (outputRule.equals("--horizontal")) {
            output = new Horizontal();
        }
        if (outputRule.equals("--vertical")) {
            output = new Vertical();
        }
        return output.output(words);
    }
}
