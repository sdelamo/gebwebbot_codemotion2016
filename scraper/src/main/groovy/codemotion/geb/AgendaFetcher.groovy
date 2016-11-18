package codemotion.geb

import codemotion.Talk
import geb.Browser

class AgendaFetcher {

    @SuppressWarnings('NestedForLoop')
    static Set<Talk> talks() {
        def browser = new Browser(baseUrl: 'https://2016.codemotion.es/')
        def page = browser.to AgendaPage

        def talks = [] as Set<Talk>

        for (int dayCount = 0; dayCount < page.dayTabs.size(); dayCount++) {
            page.dayTab(dayCount).click()
            talks += page.talks()
            for ( int i = 0; i < page.talkLinks.size();  i++) {
                page.talkLink(i).click()
                page = browser.page TalkPage
                def pageTalk = page.talk()
                def foundTalk = talks.find { it.title == pageTalk.title }
                if (foundTalk) {
                    foundTalk.tags = pageTalk.tags
                    foundTalk.about = pageTalk.about
                    foundTalk.speakers = pageTalk.speakers
                }
                page = page.close()
            }
        }
        talks
    }
}
