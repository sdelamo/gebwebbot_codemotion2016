package codemotion.geb

import geb.Module

class TalkCellModule extends Module {
    static content = {
        titleLink(required: false) { $('.ka-talk-title') }
        speakerParagraph(required: false) { $('.ka-author-brief') }
    }

    String title() {
        if ( titleLink.empty ) {
            return ''
        }
        titleLink.text()
    }

    String speaker() {
        if ( speakerParagraph.empty ) {
            return ''
        }
        speakerParagraph.text()
    }
}
