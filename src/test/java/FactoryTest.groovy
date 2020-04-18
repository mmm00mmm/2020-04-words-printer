import spock.lang.Specification
import spock.lang.Unroll

@Unroll
class FactoryTest extends Specification {
    def create() {
        //fixme:soutテストができない
//        expect:
//        Factory.create(input) == expected
//
//        where:
//        input                                                     || expected
//        ["this book is so funny", "--capitalize", "--horizontal"] || "This Book Is So Funny"
    }
}
