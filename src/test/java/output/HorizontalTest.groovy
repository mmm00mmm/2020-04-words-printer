package output

import spock.lang.Specification
import spock.lang.Unroll

@Unroll
class HorizontalTest extends Specification {
    def horizontal() {
        expect:
        new Horizontal().output(words) == expected

        where:
        words                                 || expected
        ["this", "book", "is", "so", "funny"] || "this book is so funny"
        ["this", "book", "is", " ", "funny"]  || "this book is   funny"
    }
}
