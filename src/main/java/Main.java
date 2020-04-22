import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        //Factory.create(Arrays.asList("edward gooooorey", "--compress", "--horizontal"));
        //Factory.create(Arrays.asList("edward gorey"));

        System.out.println(
                Factory.create(Arrays.asList("edward gorey", "--aaa", "--reverse", "--horizontal"))
        );
        //仕様に明記されていないことは聞く！
    }
}
