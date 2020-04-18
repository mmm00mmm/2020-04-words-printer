package convert

import spock.lang.Specification

class ReverseTest extends Specification {
    def reverse() {
        expect:
        new Reverse().convert(["this", "book", "is", "so", "funny"]) == ["funny", "so", "is", "book", "this"]
    }
}
