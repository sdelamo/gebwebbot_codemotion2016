package codemotion.geb

import codemotion.Talk
import geb.Page

class TalkPage extends Page {

    static content = {
        closeButton { $('a.ka-close') }
        talkTitleH2 { $('h2.ka-talk-details-title') }
        descriptionDiv { $('.ka-talk-details-description') }
        tagSpans { $('.tag') }
        tagSpan { i ->  $('.tag', i) }
        speakers(wait: true, required: false) { $('.ka-avatar-li') }
        speaker { i -> $('.ka-avatar-li', i).module(SpeakerModule) }
    }

    String title() {
        talkTitleH2.text()
    }

    String about() {
        descriptionDiv.text()
    }

    List<String> tags() {
        def tags = []
        for ( int i = 0; i < tagSpans.size(); i++ ) {
            tags << tagSpan(i).text()
        }
        tags
    }

    Talk talk() {
        def l = []
        if ( !speakers.empty ) {
            for ( int i = 0; i < speakers.size(); i++ ) {
                l << speaker(i).speaker()
            }
        }

        new Talk(title: title(), about: about(), tags: tags(), speakers: l)
    }

    AgendaPage close() {
        closeButton.click()
        browser.page AgendaPage
    }
}
