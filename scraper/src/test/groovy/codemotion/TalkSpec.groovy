package codemotion

import spock.lang.Specification

class TalkSpec extends Specification {
    def "test I can fetch talks"() {

        when:
        def talks = [] as Set<Talk>

        then:
        !talks.isEmpty()
    }
}
