package codemotion.geb

import codemotion.Speaker
import geb.Module

class SpeakerModule extends Module {
    static content = {
        nameLink(required: false) { $('a.ka-author-name', 0) }
        twitterLink(required: false) { $('a.ka-author-twitter', 0) }
        divDescription(required: false) { $('.ka-author-description', 0) }
    }

    String twitter() {
        if ( twitterLink.empty) {
            return ''
        }
        twitterLink.text()
    }

    String url() {
        if ( nameLink.empty) {
            return ''
        }
        nameLink.getAttribute('href')
    }

    String name() {
        if ( nameLink.empty) {
            return ''
        }
        nameLink.text()
    }

    String bio() {
        if ( divDescription.empty) {
            return ''
        }
        divDescription.text()
    }

    Speaker speaker() {
        new Speaker(
            name: name(),
            twitter: twitter(),
            url: url(),
            bio: bio())
    }

}
