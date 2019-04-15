import labs.Gray.GrayCode
import labs.Gray.GraySet
import labs.MinimalOrderChangeSet
import spock.lang.Specification
import spock.lang.Unroll

class GraySetTest extends Specification {

    private static final int binaryLength = 3

    def "Should return first element of set"() {

        given:
        MinimalOrderChangeSet<GrayCode> minimalOrderChangeSet = new GraySet(binaryLength)

        when:
        def current = minimalOrderChangeSet.current()

        then:
        current == new GrayCode(0, binaryLength)
    }

    def "should return next element of set"() {

        given:
        MinimalOrderChangeSet<GrayCode> minimalOrderChangeSet = new GraySet(binaryLength)

        when:
        minimalOrderChangeSet.next()
        minimalOrderChangeSet.next()
        minimalOrderChangeSet.next()
        def grayCode = minimalOrderChangeSet.next()

        then:
        grayCode == new GrayCode(4, binaryLength)
    }

    def "should return previous element of set"() {

        given:
        MinimalOrderChangeSet<GrayCode> minimalOrderChangeSet = new GraySet(binaryLength)

        when:
        minimalOrderChangeSet.next()
        minimalOrderChangeSet.next()
        def grayCode = minimalOrderChangeSet.previous()

        then:
        grayCode == new GrayCode(1, binaryLength)
    }

    def "should roll back to last element of set when calling previous on first element of set"() {

        given:
        MinimalOrderChangeSet<GrayCode> minimalOrderChangeSet = new GraySet(binaryLength)

        when:
        def grayCode = minimalOrderChangeSet.previous()

        then:
        grayCode == new GrayCode(7, binaryLength)
    }

    def "should roll over to first element when next is called at the end os set"() {

        given:
        MinimalOrderChangeSet<GrayCode> minimalOrderChangeSet = new GraySet(binaryLength)

        when:
        minimalOrderChangeSet.next()
        minimalOrderChangeSet.next()
        minimalOrderChangeSet.next()
        minimalOrderChangeSet.next()
        minimalOrderChangeSet.next()
        minimalOrderChangeSet.next()
        minimalOrderChangeSet.next()
        def grayCode = minimalOrderChangeSet.next()

        then:
        grayCode == new GrayCode(0, binaryLength)
    }

    @Unroll
    def "should unRank element at index #index"() {

        given:
        MinimalOrderChangeSet<GrayCode> minimalOrderChangeSet = new GraySet(binaryLength)

        when:
        def unRankedGrayCode = minimalOrderChangeSet.unRank(index)

        then:
        unRankedGrayCode == expectedGrayCode

        where:

        index || expectedGrayCode
        0     || new GrayCode(0, binaryLength)
        3     || new GrayCode(3, binaryLength)
        7     || new GrayCode(7, binaryLength)
        5     || new GrayCode(5, binaryLength)
    }

}
