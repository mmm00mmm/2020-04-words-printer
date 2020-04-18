package convert

import spock.lang.Specification
import spock.lang.Unroll

@Unroll
class CompressTest extends Specification {
    def compress() {
        expect:
        new Compress().convert(words) == expected

        where:
        words                                 || expected
        ["this", "book", "is", "so", "funny"] || ["this", "bok", "is", "so", "funy"]
        ["THIS", "BOOK", "IS", "SO", "FUNNY"] || ["THIS", "BOK", "IS", "SO", "FUNY"]
    }
}
