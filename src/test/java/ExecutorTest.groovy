import spock.lang.Specification
import spock.lang.Unroll

@Unroll
class ExecutorTest extends Specification {
    def create() {
        expect:
        Executor.run(input) == expected

        where:
        input                                                                              || expected
//        ["", "--capitalize", "--horizontal"]                                               || "" //todo:空文字の場合
        ["this book is so funny", "--capitalize", "--horizontal", "--reverse"]             || "Funny So Is Book This"
        ["this book is so funny", "--horizontal", "--compress", "--capitalize"]            || "This Bok Is So Funy"
        ["this book is so funny", "--capitalize", "--compress", "--reverse", "--vertical"] || "Funy\nSo\nIs\nBok\nThis"
    }

    def "異常系"() {
        when:
        Executor.run(input)

        then:
        def e = thrown(RuntimeException)
        e.message == expected

        where:
        input                                                                 || expected
        ["this book is so funny"]                                             || "変換引数不正"
        ["this book is so funny", "--compress"]                               || "出力引数不正"
        ["this book is so funny", "--compress", "--horizontal", "--vertical"] || "引数が2つ以上"
        ["this book is so funny", "--reverse", "--reverse", "--compress"]     || "同じ変換引数が２つ以上指定されている"
//        ["this book is so funny", "--invalid-compress", "--horizontal"] || "変換引数入力エラー" //filterかけてるので、ここには落ちない
//        ["this book is so funny", "--compress", "--invalid-horizontal"] || "出力引数入力エラー" //filterかけてるので、ここには落ちない
    }
}
