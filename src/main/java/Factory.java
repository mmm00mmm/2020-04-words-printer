import convert.Capitalize;
import convert.Compress;
import convert.Convert;
import convert.Reverse;
import output.Horizontal;
import output.Output;

import javax.swing.plaf.synth.SynthToolTipUI;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Factory {
    public static void factory(List<String> inputs) {
        List<String> word = Arrays.asList(inputs.get(0).split(" "));
        List<String> rules = inputs.stream().skip(1).collect(Collectors.toList());

        for (String rule : rules) {
            word = convertFactory(word, rule);
        }

        for (String rule : rules) {
            System.out.println(outputFactory(word, rule));
        }
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

    public static String outputFactory(List<String> words, String rules) {
        Output output = null;
        if (rules.equals("--horizontal")) {
            output = new Horizontal();
        }
        if (output == null) return "";
        return output.output(words);
    }
}
