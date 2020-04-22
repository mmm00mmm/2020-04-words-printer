package convert

import spock.lang.Specification
import spock.lang.Unroll

@Unroll
class CapitalizeTest extends Specification {
    def capitalize() {
        expect:
        new Capitalize().convert(words) == expected

        where:
        words                                 || expected
//        [""]                                  || [""] //todo
        ["a"]                                 || ["A"]
        ["this", "book", "is", "so", "funny"] || ["This", "Book", "Is", "So", "Funny"]
        ["THIS", "BOOK", "IS", "SO", "FUNNY"] || ["This", "Book", "Is", "So", "Funny"]
        ["tHIS", "bOOK", "iS", "sO", "fUNNY"] || ["This", "Book", "Is", "So", "Funny"]
    }
}
