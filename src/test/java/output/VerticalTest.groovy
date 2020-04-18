package output

import spock.lang.Specification

class VerticalTest extends Specification {
    def vertical() {
        expect:
        new Vertical().output(["this", "book", "is", "so", "funny"]) == "this\nbook\nis\nso\nfunny"
    }
}
