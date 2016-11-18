package codemotion

import codemotion.geb.AgendaFetcher
import spock.lang.Specification

class TalkSpec extends Specification {

    @SuppressWarnings('Println')
    def "test I can fetch talks"() {
        when:
        def talks = AgendaFetcher.talks()
        talks.each { println it }

        then:
        true
        !talks.isEmpty()
    }

}
